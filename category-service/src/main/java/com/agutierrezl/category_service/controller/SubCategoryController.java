package com.agutierrezl.category_service.controller;

import com.agutierrezl.category_service.dto.CategoryDTO;
import com.agutierrezl.category_service.dto.SubCategoryDTO;
import com.agutierrezl.category_service.service.ICategoryService;
import com.agutierrezl.category_service.service.ISubCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    private final ISubCategoryService subcategoryService;

    @GetMapping("")
    public ResponseEntity<List<SubCategoryDTO>> getAll() {
        return ResponseEntity.ok(subcategoryService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<SubCategoryDTO> save(@Valid @RequestBody SubCategoryDTO subcategoryDTO) {
        return ResponseEntity.ok(subcategoryService.save(subcategoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoryDTO> update(@PathVariable String id, @Valid @RequestBody SubCategoryDTO subcategoryDTO) {
        return ResponseEntity.ok(subcategoryService.update(id, subcategoryDTO));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CategoryDTO> getById(@PathVariable String id) {
//        return ResponseEntity.ok(categoryService.getById(id));
//    }
//
//    @GetMapping("/disabled/{id}")
//    public ResponseEntity<CategoryDTO> disabledById(@PathVariable String id) {
//        return ResponseEntity.ok(categoryService.disabledById(id));
//    }
//
//    @GetMapping("/enabled/{id}")
//    public ResponseEntity<CategoryDTO> enabledById(@PathVariable String id) {
//        return ResponseEntity.ok(categoryService.enabledById(id));
//    }
//
//    @GetMapping("/enabled")
//    public ResponseEntity<List<CategoryDTO>> findAllEnabled() {
//        return ResponseEntity.ok(categoryService.findAllEnabled());
//    }
}
