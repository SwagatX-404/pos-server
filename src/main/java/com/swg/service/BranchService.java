package com.swg.service;

import com.swg.exceptions.UserException;
import com.swg.model.User;
import com.swg.payload.dto.BranchDTO;

import java.util.List;

public interface BranchService {


    BranchDTO createBranch(BranchDTO branchDTO, User user) throws UserException;
    BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user);
    BranchDTO deleteBranch(Long id);

    List<BranchDTO> getAllBranchesByStoreId(Long storeId);
    BranchDTO getBranchById(Long id);
}
