package com.swg.service.impl;

import com.swg.model.Store;
import com.swg.model.User;
import com.swg.payload.dto.StoreDTO;
import com.swg.service.StoreService;

import java.util.List;

public class StoreServiceImpl implements StoreService {


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
