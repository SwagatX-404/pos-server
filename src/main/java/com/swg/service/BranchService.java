package com.swg.service;

import com.swg.exceptions.UserException;
import com.swg.model.User;
import com.swg.payload.dto.BranchDTO;

import java.util.List;

public interface BranchService {


    BranchDTO createBranch(BranchDTO branchDTO) throws UserException;
    BranchDTO updateBranch(Long id, BranchDTO branchDTO) throws Exception;
    void deleteBranch(Long id) throws Exception;

    List<BranchDTO> getAllBranchesByStoreId(Long storeId);
    BranchDTO getBranchById(Long id) throws Exception;
}
