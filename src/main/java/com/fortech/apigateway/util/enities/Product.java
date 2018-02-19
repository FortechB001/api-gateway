package com.fortech.apigateway.util.enities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String id;
    private String name;
    private String description;
}
