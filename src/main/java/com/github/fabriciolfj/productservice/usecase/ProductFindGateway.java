package com.github.fabriciolfj.productservice.usecase;

import com.github.fabriciolfj.productservice.model.ProductModel;

import java.util.UUID;

public interface ProductFindGateway {

    ProductModel process(final UUID code);
}
