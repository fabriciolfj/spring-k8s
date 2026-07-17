package com.github.fabriciolfj.productservice.mapper;

import com.github.fabriciolfj.productservice.entities.ProductEntity;
import com.github.fabriciolfj.productservice.model.ProductModel;

public final class ProductEntityMapper {

    private ProductEntityMapper() { }

    public static ProductEntity toEntity(final ProductModel model) {
        return ProductEntity.builder()
                .code(model.code())
                .name(model.name())
                .price(model.price())
                .build();
    }
}
