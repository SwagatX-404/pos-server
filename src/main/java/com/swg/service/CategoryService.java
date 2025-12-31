package com.swg.service;

import com.swg.model.Category;
import com.swg.payload.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO dto);
    List<CategoryDTO> getCategoriesByStore(Long storeId);
    CategoryDTO updateCategory(Long id, CategoryDTO dto) ;
    void deleteCategory(Long id) ;
}
