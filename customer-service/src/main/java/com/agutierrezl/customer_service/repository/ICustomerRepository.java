package com.agutierrezl.customer_service.repository;

import com.agutierrezl.customer_service.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<CustomerEntity,String> {
    List<CustomerEntity> findAllByState(String status);
}
