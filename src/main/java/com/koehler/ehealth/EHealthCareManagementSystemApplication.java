package com.koehler.ehealth;

import com.koehler.ehealth.product.ProductEntity;
import com.koehler.ehealth.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@Slf4j
@SpringBootApplication
public class EHealthCareManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EHealthCareManagementSystemApplication.class, args);
    }

    private final ProductRepository productRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            productRepository.save(ProductEntity.builder()
                    .name("Product 1")
                    .description("Description of product 1")
                    .price(100.0)
                    .quantity(50L)
                    .supplier("Company 1")
                    .usage("Headache")
                    .build());

            productRepository.save(ProductEntity.builder()
                    .name("Product 2")
                    .description("Description of product 2")
                    .price(250.0)
                    .quantity(123L)
                    .supplier("Company 2")
                    .usage("Bellyache")
                    .build());

            // fetch all customers
            log.info("Products found with findAll():");
            log.info("-------------------------------");
            for (ProductEntity productEntity : productRepository.findAll()) {
                log.info(productEntity.toString());
            }
        };
    }

}
