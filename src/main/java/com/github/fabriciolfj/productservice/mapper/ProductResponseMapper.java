package com.github.fabriciolfj.productservice.mapper;

import com.github.fabriciolfj.productservice.model.ProductModel;
import com.github.fabriciolfj.productservice.model.ProductResponse;

public final class ProductResponseMapper {

    private ProductResponseMapper() { }

    public static ProductResponse toResponse(final ProductModel model) {
        return ProductResponse
                .builder()
                .code(model.code())
                .name(model.name())
                .price(model.price())
                .build();
    }
}
