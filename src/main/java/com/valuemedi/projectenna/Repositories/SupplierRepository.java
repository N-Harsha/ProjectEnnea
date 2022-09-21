package com.valuemedi.projectenna.Repositories;

import com.valuemedi.projectenna.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Optional<Supplier> findById(Integer id);
    Optional<Supplier> findByName(String name);

}
