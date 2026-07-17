package com.github.fabriciolfj.productservice.usecase;

import com.github.fabriciolfj.productservice.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public record ProductFindUsecase(ProductFindGateway gateway) {

    public ProductModel execute(final UUID code) {
        var model = gateway.process(code);

        log.info("product found {}", model.code());
        return model;
    }
}
