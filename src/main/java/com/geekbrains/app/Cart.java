package com.geekbrains.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private final List<Product> products = new ArrayList<>();

    @Autowired  //не понял почему через конструктор лучше, ведь больше писать кода, нужно создать поле и конструктор, а тут сразу в поле.
    private ProductRepository productRepository;

    public void setProducts(int... ids) {
        for (int id : ids) {
            products.add(productRepository.getOnlyProduct(id));
        }

        System.out.println(products);
    }

    public void delProducts(int... ids){
        for (int id : ids) {
            products.remove(productRepository.getOnlyProduct(id));
        }
        System.out.println(products);
    }
}
