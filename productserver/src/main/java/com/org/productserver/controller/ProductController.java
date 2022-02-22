package com.org.productserver.controller;

import com.org.productserver.model.Product;
import com.org.productserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jos-arthur
 */

@RestController
@RequestMapping(path = "/api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{product}")
    public Product getProduct(@PathVariable("productId") Integer productId) {
        return productRepository.getOne(productId);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(
            @PathVariable
            int id,
            @RequestBody
            Product product){
        Product product1 = productRepository.findById(id);
        product1.setName(product.getName());
        product1.setTitle(product.getTitle());
        product1.setDescription(product.getDescription());
        product1.setCode(product.getCode());
        product1.setPrice(product.getPrice());
        return productRepository.save(product1);
    }


    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){

        Product product = productRepository.findById(id);
        if (product!=null) {
            productRepository.deleteById(id);
            return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Product not found",HttpStatus.METHOD_FAILURE);

    }

}
