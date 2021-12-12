package com.springangular.service;

import com.springangular.model.Product;
import com.springangular.respository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> viewProduct(){

         return productRepository.findAll();

    }

    public Optional<Product> getProduct(String productId){

        long id = Long.parseLong(productId);

        return productRepository.findById(id);

    }

    public void saveProduct(Product product){

        productRepository.save(product);

    }

    public void deleteProduct(String productId){

        long id = Long.parseLong(productId);

        productRepository.deleteById(id);

    }

}
