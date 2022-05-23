package com.koehler.ehealth.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    public ProductDTO createProduct(ProductDTO productDTO) {
        return mapper.map(productRepository.save(mapper.map(productDTO)));
    }

    public ProductDTO getProduct(Long id) {
        return mapper.map(productRepository.getById(id));
    }

    public List<ProductDTO> findAllProducts() {
        return mapper.map(productRepository.findAll());
    }

    public void deleteProduct(Long id) {
        productRepository.delete(productRepository.getById(id));
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        if (isNull(productDTO.getProductId())) {
            throw new RuntimeException("Product not informed");
        }
        productRepository.getById(productDTO.getProductId());
        return mapper.map(productRepository.save(mapper.map(productDTO)));
    }

    public List<ProductDTO> findByUsage(String usage) {
        return mapper.map(productRepository.findByUsageContaining(usage));
    }
}
