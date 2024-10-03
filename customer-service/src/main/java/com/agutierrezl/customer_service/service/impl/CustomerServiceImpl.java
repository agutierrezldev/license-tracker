package com.agutierrezl.customer_service.service.impl;

import com.agutierrezl.customer_service.dto.CustomerDTO;
import com.agutierrezl.customer_service.entity.CustomerEntity;
import com.agutierrezl.customer_service.repository.ICustomerRepository;
import com.agutierrezl.customer_service.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final ModelMapper modelMapper;
    private final ICustomerRepository customerRepository;

    @Override
    public CustomerDTO update(String id, CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        CustomerEntity customer = customerRepository.save(convertToEntity(customerDTO));
        return convertToDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerEntity> customers = (List<CustomerEntity>) customerRepository.findAll();
        return customers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getById(String id) {
        CustomerEntity customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            return convertToDTO(customer);
        }
        return null;
    }

    @Override
    public CustomerDTO disabledById(String id) {
        CustomerEntity customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setState("INACTIVO");
            customerRepository.save(customer);
            return convertToDTO(customer);
        }
        return null;
    }

    @Override
    public CustomerDTO enabledById(String id) {
        CustomerEntity customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setState("ACTIVO");
            customerRepository.save(customer);
            return convertToDTO(customer);
        }
        return null;
    }

    @Override
    public List<CustomerDTO> findAllEnabled() {
        List<CustomerEntity> customers = customerRepository.findAllByState("ACTIVO");
        return customers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    private CustomerDTO convertToDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    private CustomerEntity convertToEntity(CustomerDTO documentDTO) {
        return modelMapper.map(documentDTO, CustomerEntity.class);
    }
}
