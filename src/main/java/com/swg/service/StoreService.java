package com.swg.service;

import com.swg.domain.StoreStatus;
import com.swg.exceptions.UserException;
import com.swg.model.Store;
import com.swg.model.User;
import com.swg.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception;
    void deleteStore(Long id) throws UserException;
    StoreDTO getStoreByEmployee() throws UserException;

    StoreDTO moderateStore(Long id, StoreStatus status) throws Exception;


}
