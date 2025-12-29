package com.swg.service;

import com.swg.model.User;
import com.swg.payload.dto.ProductDTO;

import java.util.List;

public interface ProductService {


    ProductDTO createProduct(ProductDTO productDTO, User user);
    ProductDTO updateProduct(Long Id, ProductDTO ProductDTO, User user) throws Exception;
    void deleteProduct(Long id, User user);
    List<ProductDTO> getProductsByStoreId(Long storeId);
    List<ProductDTO> searchByKeyword(Long storeId, String keyword);

    }

