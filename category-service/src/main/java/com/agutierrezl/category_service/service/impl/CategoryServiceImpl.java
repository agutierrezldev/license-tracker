package com.agutierrezl.category_service.service.impl;

import com.agutierrezl.category_service.dto.CategoryDTO;
import com.agutierrezl.category_service.entity.CategoryEntity;
import com.agutierrezl.category_service.repository.ICategoryRepository;
import com.agutierrezl.category_service.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final ModelMapper modelMapper;
    private final ICategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(CategoryDTO CategoryDTO) {
        CategoryEntity category  = categoryRepository.save(convertToEntity(CategoryDTO));
        return convertToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categories = (List<CategoryEntity>) categoryRepository.findAll();
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getById(String id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            return convertToDTO(category);
        }
        return null;
    }

    @Override
    public CategoryDTO disabledById(String id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setState("INACTIVO");
            categoryRepository.save(category);
            return convertToDTO(category);
        }
        return null;
    }

    @Override
    public CategoryDTO enabledById(String id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setState("ACTIVO");
            categoryRepository.save(category);
            return convertToDTO(category);
        }
        return null;
    }

    @Override
    public List<CategoryDTO> findAllEnabled() {
        List<CategoryEntity> categories = categoryRepository.findAllByState("ACTIVO");
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO convertToDTO(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }

    public CategoryEntity convertToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }
}
