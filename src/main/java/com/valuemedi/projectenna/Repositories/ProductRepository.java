package com.valuemedi.projectenna.Repositories;

import com.valuemedi.projectenna.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
