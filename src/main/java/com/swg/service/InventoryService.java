package com.swg.service;

import com.swg.payload.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {


    InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception;
    InventoryDTO updateInventory(InventoryDTO inventoryDTO) throws Exception;
    void deleteInventory(Long id) throws Exception;
    InventoryDTO getInventoryById(Long id) throws Exception;
    InventoryDTO getInventoryByProductIdAndBranchId(Long productId, Long branchId) throws Exception;
    List<InventoryDTO> getAllInventoryByBranchId(Long branchId) throws Exception;
}
