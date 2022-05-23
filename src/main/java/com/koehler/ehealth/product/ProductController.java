package com.koehler.ehealth.product;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService service;

    @GetMapping(path = "/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<ProductDTO> findAllProducts() {
        return service.findAllProducts();
    }

    @GetMapping(params = {"usage"})
    public List<ProductDTO> findByUsage(@RequestParam(name = "usage") String usage) {
        return service.findByUsage(usage);

    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody @Validated ProductDTO productDTO) {
        return service.createProduct(productDTO);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody @Validated ProductDTO productDTO) {
        return service.updateProduct(productDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
