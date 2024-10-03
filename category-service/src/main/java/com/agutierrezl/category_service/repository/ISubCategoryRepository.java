package com.agutierrezl.category_service.repository;

import com.agutierrezl.category_service.entity.SubCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubCategoryRepository extends CrudRepository<SubCategoryEntity,String> {
    List<SubCategoryEntity> findAllByState(String status);
}
