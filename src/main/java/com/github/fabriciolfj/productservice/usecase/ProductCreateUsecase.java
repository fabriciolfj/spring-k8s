package com.github.fabriciolfj.productservice.usecase;

import com.github.fabriciolfj.productservice.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record ProductCreateUsecase(ProductCreateGateway gateway) {


    public void execute(final ProductModel model) {
        gateway.process(model);

        log.info("product save success {}", model.code());
    }
}
