package com.ut.ecommerce.searchsuggestionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class SearchSuggestionApplication {

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SearchSuggestionApplication.class, args);
    }
}
