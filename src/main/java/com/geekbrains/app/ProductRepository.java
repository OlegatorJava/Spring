package com.geekbrains.app;

import lombok.Getter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductRepository {
    @Getter
    private final List<Product> productList = new ArrayList<>();

@PostConstruct
    public void init(){
        for (int i = 0; i < 5; i++) {
            productList.add(new Product(i, "Name" + i, (int)(Math.random() * 100)));
        }

    }

    public Product getOnlyProduct(int id){
        List<Product> products = productList.stream()
                .filter(product -> product.getId() == id)
                .collect(Collectors.toList());
        Product product = products.get(0);
        return product;
    }
}
