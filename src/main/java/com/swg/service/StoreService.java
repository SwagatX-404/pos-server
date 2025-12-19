package com.swg.service;

import com.swg.model.Store;
import com.swg.model.User;
import com.swg.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id);
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin();
    StoreDTO updateStore(Long id, StoreDTO storeDTO);
    StoreDTO deleteStore(Long id);
    StoreDTO getStoreByEmployee();


}
