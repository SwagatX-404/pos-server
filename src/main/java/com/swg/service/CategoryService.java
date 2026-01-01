package com.swg.service;

import com.swg.exceptions.UserException;
import com.swg.model.Category;
import com.swg.payload.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    // create interface methods for CategoryService
    CategoryDTO createCategory(CategoryDTO dto) throws Exception;
    List<CategoryDTO> getCategoriesByStore(Long storeId);
    CategoryDTO updateCategory(Long id, CategoryDTO dto) throws Exception;
    void deleteCategory(Long id) throws Exception;
}
