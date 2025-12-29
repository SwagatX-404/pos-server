package com.swg.service.impl;

import com.swg.model.User;
import com.swg.payload.dto.ProductDTO;
import com.swg.repository.ProductRepository;
import com.swg.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long Id, ProductDTO ProductDTO, User user) {
        return null;
    }

    @Override
    public void deleteProduct(Long id, User user) {

    }

    @Override
    public List<ProductDTO> getProductsByStoreId(Long storeId) {
        return List.of();
    }

    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {
        return List.of();
    }
}
