package com.github.fabriciolfj.productservice.adapter;

import com.github.fabriciolfj.productservice.model.ProductModel;
import com.github.fabriciolfj.productservice.repository.ProductRepository;
import com.github.fabriciolfj.productservice.usecase.ProductFindGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.github.fabriciolfj.productservice.mapper.ProductModelMapper.toModel;

@Component
@RequiredArgsConstructor
public class ProductFindAdapter implements ProductFindGateway {

    private final ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ProductModel process(UUID code) {
        var entity = repository.findByCode(code)
                .orElseThrow(RuntimeException::new);

        return toModel(entity);
    }
}
