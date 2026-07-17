package com.github.fabriciolfj.productservice.mapper;

import com.github.fabriciolfj.productservice.dtos.ProductRequest;
import com.github.fabriciolfj.productservice.entities.ProductEntity;
import com.github.fabriciolfj.productservice.model.ProductModel;

import java.util.UUID;

public final class ProductModelMapper {

    private ProductModelMapper() { }

    public static ProductModel toModel(final ProductRequest request) {
        return ProductModel.builder()
                .code(UUID.randomUUID())
                .name(request.name()).
                price(request.price())
                .build();
    }

    public static ProductModel toModel(final ProductEntity entity) {
        return ProductModel.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }
}
