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
public class EHealthAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(EHealthAPIApplication.class, args);
    }

    private final ProductRepository productRepository;


    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            productRepository.save(ProductEntity.builder()
                    .name("Throatcalm Homeopathic Tablets for Sore Throat Relief")
                    .description("ThroatCalm tablets relieve minor sore throat associated with colds and hoarseness from overused vocal cords. The homeopathic tablets dissolve under the tongue, causing no additional pain to swallow.")
                    .price(11.99)
                    .quantity(50L)
                    .supplier("Boiron")
                    .usage("Temporarily relieves minor sore throat and hoarseness")
                    .imageUrl("https://pics.drugstore.com/prodimg/609580/450.jpg")
                    .build());

            productRepository.save(ProductEntity.builder()
                    .name("Sore Throat Spray Cherry Cherry")
                    .description("Chloraseptic Sore Throat Cherry is used for the temporary relief of occasional minor irritation, pain, sore mouth and sore throat.")
                    .price(8.79)
                    .quantity(123L)
                    .supplier("Chloraseptic")
                    .usage("Relieves sore mouth and sore throat")
                    .imageUrl("https://pics.drugstore.com/prodimg/11085/450.jpg")
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
