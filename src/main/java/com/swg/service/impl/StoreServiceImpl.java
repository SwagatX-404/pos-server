package com.swg.service.impl;

import com.swg.mapper.StoreMapper;
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

        Store store = StoreMapper.toEntity(storeDTO, user);

        return StoreMapper.toDTO(storeRepository.save(store));
    }



    @Override
    public StoreDTO getStoreById(Long id) throws Exception {

        Store store = storeRepository.findById(id).orElseThrow(
                ()-> new Exception("Store not found....!")
        );
        return StoreMapper.toDTO(store);
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
