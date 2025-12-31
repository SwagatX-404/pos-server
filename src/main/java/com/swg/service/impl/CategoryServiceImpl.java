package com.swg.service.impl;


import com.swg.payload.dto.CategoryDTO;
import com.swg.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        return null;
    }

    @Override
    public List<CategoryDTO> getCategoriesByStore(Long storeId) {
        return List.of();
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
