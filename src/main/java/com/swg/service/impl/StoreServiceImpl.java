package com.swg.service.impl;

import com.swg.model.Store;
import com.swg.model.User;
import com.swg.payload.dto.StoreDTO;
import com.swg.repository.StoreRepository;
import com.swg.service.StoreService;
import com.swg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {


    private  final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public StoreDTO createStore(StoreDTO storeDTO, User user) {
        return null;
    }

    @Override
    public StoreDTO getStoreById(Long id) {
        return null;
    }

    @Override
    public List<StoreDTO> getAllStores() {
        return List.of();
    }

    @Override
    public Store getStoreByAdmin() {
        return null;
    }

    @Override
    public StoreDTO updateStore(Long id, StoreDTO storeDTO) {
        return null;
    }

    @Override
    public StoreDTO deleteStore(Long id) {
        return null;
    }

    @Override
    public StoreDTO getStoreByEmployee() {
        return null;
    }
}
