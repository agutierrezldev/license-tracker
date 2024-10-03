package com.agutierrezl.customer_service.service;

import com.agutierrezl.customer_service.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    CustomerDTO update(String id, CustomerDTO customerDTO);
    CustomerDTO save(CustomerDTO customerDTO);
    List<CustomerDTO> getAll();
    CustomerDTO getById(String id);
    CustomerDTO disabledById(String id);
    CustomerDTO enabledById(String id);
    List<CustomerDTO> findAllEnabled();

}
