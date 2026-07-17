package com.github.fabriciolfj.productservice.usecase;

import com.github.fabriciolfj.productservice.model.ProductModel;

public interface ProductCreateGateway {

    void process(final ProductModel model);
}
