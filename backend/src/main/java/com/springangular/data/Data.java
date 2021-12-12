package com.springangular.data;

import com.springangular.model.Product;
import com.springangular.respository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Data implements CommandLineRunner {


    private final ProductRepository productRepository;

    public Data(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        Product product = new Product();
        product.setProductName("Apple");
        product.setProductDesc("This is an Apple");
        product.setProductPrice(30);

        productRepository.save(product);

        Product shoes = new Product();
        shoes.setProductName("Shoes");
        shoes.setProductDesc("This are shoes");
        shoes.setProductPrice(100);

        productRepository.save(shoes);


    }
}
