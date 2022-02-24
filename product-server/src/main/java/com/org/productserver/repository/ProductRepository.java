package com.org.productserver.repository;

import com.org.productserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jos-arthur
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findById(int id);
    public void deleteById(int id);
}
