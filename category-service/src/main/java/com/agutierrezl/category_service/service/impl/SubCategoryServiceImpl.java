package com.agutierrezl.category_service.service.impl;

import com.agutierrezl.category_service.dto.CategoryDTO;
import com.agutierrezl.category_service.dto.SubCategoryDTO;
import com.agutierrezl.category_service.entity.CategoryEntity;
import com.agutierrezl.category_service.entity.SubCategoryEntity;
import com.agutierrezl.category_service.repository.ICategoryRepository;
import com.agutierrezl.category_service.repository.ISubCategoryRepository;
import com.agutierrezl.category_service.service.ISubCategoryService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements ISubCategoryService {

    private final ModelMapper modelMapper;
    private final ICategoryRepository categoryRepository;
    private final CategoryServiceImpl categoryServiceimpl;

    private final ISubCategoryRepository subcategoryRepository;

    @Override
    public SubCategoryDTO update(String id, SubCategoryDTO subcategoryDTO) {
        SubCategoryEntity subcategory = subcategoryRepository.findById(id).orElse(null);

        if (subcategory != null) {
            CategoryEntity category = categoryRepository.findById(subcategoryDTO.getCategory().getId()).orElse(null);

            if (category != null) {
                subcategoryDTO.setId(id);
                subcategoryDTO.setCategory(categoryServiceimpl.convertToDTO(category));

                return convertToDTO(subcategoryRepository.save(convertToEntity(subcategoryDTO)));
            }
        }
        return null;
    }

    @Override
    public SubCategoryDTO save(SubCategoryDTO subcategoryDTO) {
        CategoryEntity category = categoryRepository.findById(subcategoryDTO.getCategory().getId()).orElse(null);
        if (category != null) {
            subcategoryDTO.setCategory(categoryServiceimpl.convertToDTO(category));
            SubCategoryEntity subcategory = subcategoryRepository.save(convertToEntity(subcategoryDTO));
            return convertToDTO(subcategory);
        }
        return null;
    }

    @Override
    public List<SubCategoryDTO> getAll() {
        List<SubCategoryEntity> subcategories = (List<SubCategoryEntity>) subcategoryRepository.findAll();
        return subcategories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryDTO getById(String id) {
        return null;
    }

    @Override
    public SubCategoryDTO enabledById(String id) {
        return null;
    }

    private SubCategoryDTO convertToDTO(SubCategoryEntity subcategoryEntity) {
        return modelMapper.map(subcategoryEntity, SubCategoryDTO.class);
    }

    private SubCategoryEntity convertToEntity(SubCategoryDTO subcategoryDTO) {
        return modelMapper.map(subcategoryDTO, SubCategoryEntity.class);
    }
}
