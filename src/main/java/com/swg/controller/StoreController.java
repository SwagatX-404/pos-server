package com.swg.controller;


import com.swg.exceptions.UserException;
import com.swg.mapper.StoreMapper;
import com.swg.model.User;
import com.swg.payload.dto.StoreDTO;
import com.swg.payload.response.ApiResponse;
import com.swg.service.StoreService;
import com.swg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {


    private final StoreService storeService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(
            @RequestBody StoreDTO storeDTO,
            @RequestHeader ("Authorization") String jwt) throws UserException {

        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(storeService.createStore(storeDTO, user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(
            @PathVariable Long id,
            @RequestHeader ("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(storeService.getStoreById(id));
    }


    @GetMapping()
    public ResponseEntity<List<StoreDTO>> getAllStore(

            @RequestHeader ("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(storeService.getAllStores());
    }


    @GetMapping("/admin")
    public ResponseEntity<StoreDTO> getStoreByAdmin(

            @RequestHeader ("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(StoreMapper.toDTO(storeService.getStoreByAdmin()));
    }


    @GetMapping("/employee")
    public ResponseEntity<StoreDTO> getStoreByEmployee(

            @RequestHeader ("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(storeService.getStoreByEmployee());
    }


    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> updateStore(
            @PathVariable Long id,
            @RequestBody StoreDTO storeDTO ) throws Exception {

        return ResponseEntity.ok(storeService.updateStore(id, storeDTO));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStore(
            @PathVariable Long id ) throws Exception {

        storeService.deleteStore(id);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Store deleted successfully..!");
        return ResponseEntity.ok(apiResponse);
    }

}
