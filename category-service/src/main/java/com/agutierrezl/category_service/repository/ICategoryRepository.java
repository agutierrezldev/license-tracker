package com.agutierrezl.category_service.repository;

import com.agutierrezl.category_service.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity,String> {
    List<CategoryEntity> findAllByState(String status);
}
