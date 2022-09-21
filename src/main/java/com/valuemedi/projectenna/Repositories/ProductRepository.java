package com.valuemedi.projectenna.Repositories;

import com.valuemedi.projectenna.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Optional<Product> findByCode(String code);
}
