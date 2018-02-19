package com.fortech.apigateway.service;

import com.fortech.apigateway.util.enities.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "productAllFallback")
    public List getAllProducts() {
        URI uri = URI.create("http://localhost:8083/product/all");
        return restTemplate.getForObject(uri, List.class);
    }

    public List productAllFallback() {

        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Bananas", "Banana Description"));
        products.add(new Product("2", "Cherys", "Cherys Description"));
        products.add(new Product("3", "Melon", "Melon Description"));
        products.add(new Product("4", "Lime", "Melon Description"));
        return products;
    }

   // @HystrixCommand
    public ResponseEntity<?> addStock(String name, String description) {
        URI uri = URI.create("http://localhost:8083/product/add?name=" + name + "&description=" + description);
        return restTemplate.postForObject(uri, null, ResponseEntity.class);
    }

   // @HystrixCommand
    public ResponseEntity<?> changeProductName(String productId, String newProductName) {
        URI uri = URI.create("http://localhost:8083/product/productName/update?productId=" + productId + "&newProductName=" + newProductName);
        return restTemplate.exchange(uri, HttpMethod.PUT, null, ResponseEntity.class);
    }

   // @HystrixCommand
    public ResponseEntity<?> deleteProduct(String productId) {
        URI uri = URI.create("http://localhost:8083/product/delete?productId=" + productId);
        return restTemplate.exchange(uri, HttpMethod.DELETE, null, ResponseEntity.class);
    }
}
