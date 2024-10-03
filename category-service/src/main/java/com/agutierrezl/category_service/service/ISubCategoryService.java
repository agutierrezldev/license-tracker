package com.agutierrezl.category_service.service;

import com.agutierrezl.category_service.dto.SubCategoryDTO;

import java.util.List;

public interface ISubCategoryService {
    SubCategoryDTO update(String id, SubCategoryDTO subcategoryDTO);
    SubCategoryDTO save(SubCategoryDTO subcategoryDTO);
    List<SubCategoryDTO> getAll();
    SubCategoryDTO getById(String id);
    SubCategoryDTO enabledById(String id);
}
