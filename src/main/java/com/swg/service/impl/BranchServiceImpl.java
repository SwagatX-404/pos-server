package com.swg.service.impl;

import com.swg.exceptions.UserException;
import com.swg.mapper.BranchMapper;
import com.swg.model.Branch;
import com.swg.model.Store;
import com.swg.model.User;
import com.swg.payload.dto.BranchDTO;
import com.swg.repository.BranchRepository;
import com.swg.repository.StoreRepository;
import com.swg.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final UserServiceImpl userService;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO, User user) throws UserException {

        User currentUser=userService.getCurrentUser();
        Store store=storeRepository.findByStoreAdminId(currentUser.getId());

        Branch branch= BranchMapper.toEntity(branchDTO, store);
        Branch savedBranch=branchRepository.save(branch);

        return BranchMapper.toDTO(savedBranch);
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user) {
        return null;
    }

    @Override
    public BranchDTO deleteBranch(Long id) {
        return null;
    }

    @Override
    public List<BranchDTO> getAllBranchesByStoreId(Long storeId) {
        return List.of();
    }

    @Override
    public BranchDTO getBranchById(Long id) {
        return null;
    }
}
