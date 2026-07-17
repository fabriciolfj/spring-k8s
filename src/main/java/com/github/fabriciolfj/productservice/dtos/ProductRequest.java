package com.github.fabriciolfj.productservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(@NotBlank(message = "name is required") String name,
                             @NotNull(message = "price is required")
                             @Positive(message = "value invalid")
                             BigDecimal price) { }
