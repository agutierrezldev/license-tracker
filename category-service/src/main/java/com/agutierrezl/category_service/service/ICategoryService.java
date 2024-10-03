package com.agutierrezl.category_service.service;

import com.agutierrezl.category_service.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    CategoryDTO save(CategoryDTO CategoryDTO);
    List<CategoryDTO> getAll();
    CategoryDTO getById(String id);
    CategoryDTO disabledById(String id);
    CategoryDTO enabledById(String id);
    List<CategoryDTO> findAllEnabled();
}
