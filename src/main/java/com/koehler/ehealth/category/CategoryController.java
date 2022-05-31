package com.koehler.ehealth.category;

import com.koehler.ehealth.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    private final CartService service;

    @GetMapping
    public List<CategoryDTO> getCategories() {

        return List.of(
                CategoryDTO.builder().id(1L).name("Cough, Cold & Flu").build(),
                CategoryDTO.builder().id(2L).name("Allergy & Sinus").build(),
                CategoryDTO.builder().id(3L).name("First Aid").build(),
                CategoryDTO.builder().id(4L).name("Pain Relief & Management").build(),
                CategoryDTO.builder().id(5L).name("Digestive Health & Nausea").build()

        );
    }

}
