package com.swg.service.impl;

import com.swg.model.Refund;
import com.swg.payload.dto.RefundDTO;
import com.swg.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {
    @Override
    public RefundDTO createRefund(Refund refund) throws Exception {
        return null;
    }

    @Override
    public List<RefundDTO> getAllRefunds() throws Exception {
        return List.of();
    }

    @Override
    public RefundDTO getRefundByCashier(Long cashierId) throws Exception {
        return null;
    }

    @Override
    public RefundDTO getRefundByShiftReport(Long shiftReportId) throws Exception {
        return null;
    }

    @Override
    public List<RefundDTO> getRefundByCashierAndDateRange(Long cashierId, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        return List.of();
    }

    @Override
    public List<RefundDTO> getRefundByBranch(Long branchId) throws Exception {
        return List.of();
    }

    @Override
    public RefundDTO getRefundById(Long refundId) throws Exception {
        return null;
    }

    @Override
    public void deleteRefund(Long refundId) throws Exception {

    }
}
