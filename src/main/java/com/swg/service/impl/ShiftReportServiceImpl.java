package com.swg.service.impl;

import com.swg.exceptions.UserException;
import com.swg.payload.dto.ShiftReportDTO;
import com.swg.repository.ShiftReportRepository;
import com.swg.service.ShiftReportService;
import com.swg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftReportServiceImpl implements ShiftReportService {

    private final ShiftReportRepository shiftReportRepository;
    private final UserService userService;

    @Override
    public ShiftReportDTO startShift(Long cashierId,
                                     Long branchId,
                                     LocalDateTime shiftStart) throws Exception {
        return null;
    }

    @Override
    public ShiftReportDTO endShift(Long shiftReportId, LocalDateTime shiftEnd) throws Exception {
        return null;
    }

    @Override
    public ShiftReportDTO getShiftReportById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<ShiftReportDTO> getAllShiftReports() {
        return List.of();
    }

    @Override
    public List<ShiftReportDTO> GetShiftReportsByBranchId(Long branchId) {
        return List.of();
    }

    @Override
    public List<ShiftReportDTO> GetShiftReportsByCashierId(Long cashierId) {
        return List.of();
    }

    @Override
    public ShiftReportDTO getCurrentShiftProgress(Long cashierId) throws UserException {
        return null;
    }

    @Override
    public ShiftReportDTO getShiftByCashierAndDate(Long cashierId, LocalDateTime date) throws Exception {
        return null;
    }
}
