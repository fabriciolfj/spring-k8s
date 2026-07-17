package com.github.fabriciolfj.productservice.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(toBuilder = true)
public record ProductModel(UUID code, String name, BigDecimal price) {
}
