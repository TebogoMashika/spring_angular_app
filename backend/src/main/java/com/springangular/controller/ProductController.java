package com.springangular.controller;

import com.springangular.model.Product;
import com.springangular.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(ProductController.BASE_URL)
@CrossOrigin
public class ProductController {

    public static final String BASE_URL = "restful-service/";
    public static final String VIEW_PRODUCT = "/view_products";
    public static final String GET_PRODUCT = "/get_product/{id}";
    public static final String SAVE_PRODUCT = "/save_product";
    public static final String DELETE_PRODUCT = "/delete_product/{id}";
    public static final String UPDATE_PRODUCT = "/update_product";


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }




    @GetMapping(VIEW_PRODUCT)
    public Iterable<Product> requestViewProduct(){

        return productService.viewProduct();

    }
    @RequestMapping(GET_PRODUCT)
    public Optional<Product> requestProduct(@PathVariable(value = "id") String id){

         return productService.getProduct(id);

    }

    @PostMapping(SAVE_PRODUCT)
    public void requestSaveProduct(@RequestBody Product product){

        productService.saveProduct(product);

    }

    @DeleteMapping(DELETE_PRODUCT)
    public void requestDeleteProduct(@PathVariable(value = "id") String id){

        productService.deleteProduct(id);

    }

    @PutMapping(UPDATE_PRODUCT)
    public void requestUpdateProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }


}
