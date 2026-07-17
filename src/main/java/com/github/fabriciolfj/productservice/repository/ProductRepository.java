package com.github.fabriciolfj.productservice.repository;

import com.github.fabriciolfj.productservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByCode(final UUID code);
}
