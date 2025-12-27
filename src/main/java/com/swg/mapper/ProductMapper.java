package com.swg.mapper;

import com.swg.model.Product;
import com.swg.model.Store;
import com.swg.payload.dto.ProductDTO;

public class ProductMapper {

    public ProductDTO toDTO(Product product){

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .description(product.getDescription())
                .mrp(product.getMrp())
                .selligPrice(product.getSelligPrice())
                .brand(product.getBrand())
                .storeId(product.getStore()!=null?product.getStore().getId():null)
                .image(product.getImage())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
        //.categoryId(product.getCategory()!=null?product.getCategory().getId():null)

    }

    public Product toEntity(ProductDTO productDTO, Store store){

       return Product.builder()
                .name(productDTO.getName())
                .sku(productDTO.getSku())
                .description(productDTO.getDescription())
                .mrp(productDTO.getMrp())
                .selligPrice(productDTO.getSelligPrice())
                .brand(productDTO.getBrand())
                .build();

    }
}
