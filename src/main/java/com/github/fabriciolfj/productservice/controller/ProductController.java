package com.github.fabriciolfj.productservice.controller;

import com.github.fabriciolfj.productservice.dtos.ProductRequest;
import com.github.fabriciolfj.productservice.model.ProductResponse;
import com.github.fabriciolfj.productservice.usecase.ProductCreateUsecase;
import com.github.fabriciolfj.productservice.usecase.ProductFindGateway;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.github.fabriciolfj.productservice.mapper.ProductModelMapper.toModel;
import static com.github.fabriciolfj.productservice.mapper.ProductResponseMapper.toResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductCreateUsecase usecaseCreate;
    private final ProductFindGateway usecaseFind;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid final ProductRequest request) {
        var model = toModel(request);

        usecaseCreate.execute(model);
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse findProduct(@PathVariable("code") final UUID code) {
        var model = usecaseFind.process(code);

        return toResponse(model);
    }
}
