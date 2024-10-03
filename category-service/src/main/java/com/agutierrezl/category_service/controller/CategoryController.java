package com.agutierrezl.category_service.controller;

import com.agutierrezl.category_service.dto.CategoryDTO;
import com.agutierrezl.category_service.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO CategoryDTO) {
        return ResponseEntity.ok(categoryService.save(CategoryDTO));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping("/disabled/{id}")
    public ResponseEntity<CategoryDTO> disabledById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.disabledById(id));
    }

    @GetMapping("/enabled/{id}")
    public ResponseEntity<CategoryDTO> enabledById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.enabledById(id));
    }

    @GetMapping("/enabled")
    public ResponseEntity<List<CategoryDTO>> findAllEnabled() {
        return ResponseEntity.ok(categoryService.findAllEnabled());
    }
}
