package com.swg.service;

import com.swg.model.User;
import com.swg.payload.dto.StoreDTO;

public interface StoreService {

    StoreDTO createStore(StoreDTO storeDTO, User user);

}
