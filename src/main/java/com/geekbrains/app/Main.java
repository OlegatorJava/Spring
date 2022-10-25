package com.geekbrains.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext("com.geekbrains.app");

        ProductRepository productRepository = context.getBean(ProductRepository.class);

        System.out.println(productRepository.getProductList());
        System.out.println(productRepository.getOnlyProduct(2));

        context.getBean(Cart.class)
        .setProducts(2);

        Cart cart = context.getBean(Cart.class);
        cart.setProducts(0,2,4);
        cart.delProducts(0);



    }
}
