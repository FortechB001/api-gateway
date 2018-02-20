package com.fortech.apigateway.controller;

import com.fortech.apigateway.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProxyProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/api/product-service-all/product/all")
    public List getAllProducts() {
        return productService.getAllProducts();
    }

/*    @PostMapping(value = "/add")
    public ResponseEntity<?> addStock(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "description", required = false) String description) {
        return productService.addStock(name, description);
    }

    @PutMapping(path = "/productName/update")
    public ResponseEntity<?> changeProductName(@RequestParam(name = "productId") String productId,
                                               @RequestParam(name = "newProductName") String newProductName) {
        return productService.changeProductName(productId, newProductName);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam(name = "productId") String productId) {
        return productService.deleteProduct(productId);
    }*/
}
