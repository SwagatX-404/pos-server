package com.swg.service.impl;

import com.swg.domain.PaymentType;
import com.swg.exceptions.UserException;
import com.swg.mapper.ShiftReportMapper;
import com.swg.model.*;
import com.swg.payload.dto.ShiftReportDTO;
import com.swg.repository.OrderRepository;
import com.swg.repository.RefundRepository;
import com.swg.repository.ShiftReportRepository;
import com.swg.repository.UserRepository;
import com.swg.service.ShiftReportService;
import com.swg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShiftReportServiceImpl implements ShiftReportService {

    private final ShiftReportRepository shiftReportRepository;
    private final UserService userService;
    private final RefundRepository refundRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    @Override
    public ShiftReportDTO startShift(Long cashierId,
                                     Long branchId,
                                     LocalDateTime shiftStart) throws Exception {

        User currentUser =  userService.getUserById(cashierId);
        shiftStart = LocalDateTime.now();
        LocalDateTime startOfDay = shiftStart.withHour(0).withMinute(0).withSecond(0);

        LocalDateTime endOfDay = shiftStart.withHour(23).withMinute(59).withSecond(59);

        Optional<ShiftReport> existing = shiftReportRepository
                .findByCashierAndShiftStartBetween(currentUser, startOfDay, endOfDay);

        if(existing.isPresent()) {
            throw new UserException("Shift already started for today");
        }

        Branch branch = currentUser.getBranch();

        ShiftReport shiftReport = ShiftReport.builder()
                .cashier(currentUser)
                .branch(branch)
                .shiftStart(shiftStart)
                .build();

        ShiftReport savedReport =  shiftReportRepository.save(shiftReport);

        return ShiftReportMapper.toDTO(savedReport);
    }

    @Override
    public ShiftReportDTO endShift(Long shiftReportId, LocalDateTime shiftEnd) throws Exception {

        User currentUser = userService.getCurrentUser();

        ShiftReport shiftReport = shiftReportRepository.findByTopCashierAndShiftEndIsNullOrderByShiftStartDesc(currentUser)
                .orElseThrow(() -> new UserException("Shift report not found...!"));

        shiftReport.setShiftEnd(shiftEnd);

        List<Refund> refunds= refundRepository.findByCashierIdAndCreatedAtBetween(
                currentUser.getId(),
                shiftReport.getShiftStart(),
                shiftReport.getShiftEnd()
        );

        double totalRefunds = refunds.stream()
                .mapToDouble( refund -> refund.getAmount()!=null? refund.getAmount():0.0 ).sum();

        List<Order> orders = orderRepository.findByCashierAndCreatedAtBetween(
                currentUser,
                shiftReport.getShiftStart(),
                shiftReport.getShiftEnd()
        );

        double totalSales = orders.stream()
                .mapToDouble(Order::getTotalAmount).sum();

        int totalOrders = orders.size();

        double netSales = totalSales - totalRefunds;

        shiftReport.setTotalRefunds(totalRefunds);
        shiftReport.setTotalSales(totalSales);
        shiftReport.setNetSales(netSales);
        shiftReport.setTotalOrders(totalOrders);

        shiftReport.setRecentOrders(getRecentOrders(orders));
        shiftReport.setTopSellingProducts(getTopSellingProducts(orders));
        shiftReport.setPaymentSummaries(getPaymentSummaries(orders, totalSales));
        shiftReport.setRefunds(refunds);

        ShiftReport savedReport = shiftReportRepository.save(shiftReport);
        return ShiftReportMapper.toDTO(savedReport);


    }




    @Override
    public ShiftReportDTO getShiftReportById(Long id) throws Exception {
        return shiftReportRepository.findById(id)
                .map(ShiftReportMapper::toDTO)
                .orElseThrow(
                ()-> new Exception("Shift Report not found...!"));

    }

    @Override
    public List<ShiftReportDTO> getAllShiftReports() {
        List<ShiftReport> reports = shiftReportRepository.findAll();
        return reports.stream().map(
                ShiftReportMapper::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<ShiftReportDTO> GetShiftReportsByBranchId(Long branchId) {

        List<ShiftReport> reports = shiftReportRepository.findByBranchId(branchId);
        return reports.stream().map(
                ShiftReportMapper::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<ShiftReportDTO> GetShiftReportsByCashierId(Long cashierId) {
        List<ShiftReport> reports = shiftReportRepository.findByCashierId(cashierId);
        return reports.stream()
                .map(ShiftReportMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ShiftReportDTO getCurrentShiftProgress(Long cashierId) throws UserException {

        User user = userService.getCurrentUser();

        ShiftReport shiftReport = shiftReportRepository
                .findByTopCashierAndShiftEndIsNullOrderByShiftStartDesc(user).orElseThrow(
                        ()-> new UserException("No active shift found for the user/cashier..!")
                );

        LocalDateTime now = LocalDateTime.now();



        List <Order> orders = orderRepository.findByCashierAndCreatedAtBetween(
                user,
                shiftReport.getShiftStart(),
                now
        );

        /// ///
        List<Refund> refunds= refundRepository.findByCashierIdAndCreatedAtBetween(
                user.getId(),
                shiftReport.getShiftStart(),
                shiftReport.getShiftEnd()
        );

        double totalRefunds = refunds.stream()
                .mapToDouble( refund -> refund.getAmount()!=null? refund.getAmount():0.0 ).sum();


        double totalSales = orders.stream()
                .mapToDouble(Order::getTotalAmount).sum();

        int totalOrders = orders.size();

        double netSales = totalSales - totalRefunds;

        shiftReport.setTotalRefunds(totalRefunds);
        shiftReport.setTotalSales(totalSales);
        shiftReport.setNetSales(netSales);
        shiftReport.setTotalOrders(totalOrders);

        shiftReport.setRecentOrders(getRecentOrders(orders));
        shiftReport.setTopSellingProducts(getTopSellingProducts(orders));
        shiftReport.setPaymentSummaries(getPaymentSummaries(orders, totalSales));
        shiftReport.setRefunds(refunds);

        ShiftReport savedReport = shiftReportRepository.save(shiftReport);


        return ShiftReportMapper.toDTO(savedReport);
    }

    @Override
    public ShiftReportDTO getShiftByCashierAndDate(Long cashierId,
                                                   LocalDateTime date) throws Exception {

        User cashier = userRepository.findById(cashierId)
                .orElseThrow(()-> new Exception("Cashier not found...!"+cashierId));

        LocalDateTime start = date.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime end = date.withHour(23).withMinute(59).withSecond(59);

        ShiftReport report = shiftReportRepository
                .findByCashierAndShiftStartBetween(cashier, start, end)
                .orElseThrow(()-> new Exception("Shift Report not found for the cashier...!"));

        return ShiftReportMapper.toDTO(report);
    }




    //-----------------------------------Helpers Methods---------------------------------------//

    private List<PaymentSummary> getPaymentSummaries(List<Order> orders, double totalSales) {

         //CASH - order 1(amount=1000), order2(amount=1000) => 2000
        //CARD - order 3  => 3000
        //UPI - order 4(amount =500), order 5 (amount = 500)  => 1000

        //cash = 30%
        //card = 50%
        //upi = 20%

        Map<PaymentType, List<Order>> grouped = orders.stream()
                .collect(Collectors.groupingBy(order-> order.getPaymentType()!=null?
                        order.getPaymentType(): PaymentType.CASH ));

        List<PaymentSummary> summaries = new ArrayList<>();
        for(Map.Entry<PaymentType, List<Order>> entry : grouped.entrySet()) {

                double amount = entry.getValue().stream()
                        .mapToDouble(Order::getTotalAmount)
                        .sum();
                int transactions  = entry.getValue().size();
                double percente = (amount / totalSales) * 100;

                PaymentSummary ps = new PaymentSummary();
                ps.setType(entry.getKey());
                ps.setTotalAmount(amount);
                ps.setTransactionCount(transactions);
                ps.setPercentage(percente);
                summaries.add(ps);

        }

        return summaries;

    }

    private List<Product> getTopSellingProducts(List<Order> orders) {

        Map<Product, Integer> productSalesMap = new HashMap<>();

        //p4 - 8
        //p2 - 5
        //p1 - 3
        //p3 - 2
        //p5 - 1

        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                Product product = item.getProduct();
                productSalesMap.put(product,
                        productSalesMap.getOrDefault(product, 0) + item.getQuantity());
            }
        }

        return productSalesMap.entrySet().stream()
                .sorted((a,b)-> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<Order> getRecentOrders(List<Order> orders) {

        return orders.stream()
                .sorted(Comparator.comparing(Order::getCreatedAt).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
