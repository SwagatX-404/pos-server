package com.swg.service;

import com.swg.exceptions.UserException;
import com.swg.payload.dto.ShiftReportDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ShiftReportService {

    ShiftReportDTO startShift( ) throws Exception;

    ShiftReportDTO endShift(Long shiftReportId, LocalDateTime shiftEnd) throws Exception;

    ShiftReportDTO getShiftReportById(Long id) throws Exception;

    List<ShiftReportDTO> getAllShiftReports();

    List<ShiftReportDTO> getShiftReportsByBranchId(Long branchId);
    List<ShiftReportDTO> getShiftReportsByCashierId(Long cashierId);

    ShiftReportDTO getCurrentShiftProgress(Long cashierId) throws UserException;

    ShiftReportDTO getShiftByCashierAndDate(Long cashierId, LocalDateTime date) throws Exception;



}
