package org.fasttrackit.onlineshopapi.repository;

import org.fasttrackit.onlineshopapi.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //queries derived from method names

    Page < Product > findByNameContaining(String partialName, Pageable pageable);

    Page <Product> findByNameContainingAndQuantityGreaterThanEqual(String partialName, int minQuantity, Pageable pageable);

//    @Query (" SELECT product FROM Product WHERE name LIKE '%?1' ")
    @Query (value = " SELECT product FROM Product WHERE name LIKE '%?1' ", nativeQuery = true)

    Page<Product> findByPartialName(String partialName, Pageable pageable);
    }



