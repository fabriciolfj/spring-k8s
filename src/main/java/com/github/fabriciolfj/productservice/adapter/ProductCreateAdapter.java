package com.github.fabriciolfj.productservice.adapter;

import com.github.fabriciolfj.productservice.model.ProductModel;
import com.github.fabriciolfj.productservice.repository.ProductRepository;
import com.github.fabriciolfj.productservice.usecase.ProductCreateGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.github.fabriciolfj.productservice.mapper.ProductEntityMapper.toEntity;

@Component
@RequiredArgsConstructor
public class ProductCreateAdapter implements ProductCreateGateway {

    private final ProductRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void process(ProductModel model) {
        var entity = toEntity(model);

        repository.save(entity);
    }
}
