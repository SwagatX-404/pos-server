package com.swg.service.impl;

import com.swg.payload.dto.InventoryDTO;
import com.swg.service.InventoryService;

import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception {
        return null;
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) throws Exception {
        return null;
    }

    @Override
    public void deleteInventory(Long id) throws Exception {

    }

    @Override
    public InventoryDTO getInventoryById(Long id) throws Exception {
        return null;
    }

    @Override
    public InventoryDTO getInventoryByProductIdAndBranchId(Long productId, Long branchId) throws Exception {
        return null;
    }

    @Override
    public List<InventoryDTO> getAllInventoryByBranchId(Long branchId) throws Exception {
        return List.of();
    }
}
