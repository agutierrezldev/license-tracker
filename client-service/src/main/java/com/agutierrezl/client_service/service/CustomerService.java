package com.agutierrezl.client_service.service;

import com.agutierrezl.client_service.model.response.CustomerDTO;
import com.agutierrezl.client_service.model.response.CustomerResponseDTO;
import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.proxy.openfeign.ICloudGatewayServiceFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ICloudGatewayServiceFeign serviceFeign;


    public List<CustomerResponseDTO> getAll() {

        List<CustomerResponseDTO> customers = new ArrayList<>();
        List<CustomerDTO> customersService = serviceFeign.getAllCustomers();

        customersService.forEach(customerService -> {
            try {
                // Search documentType
                DocumentDTO documentDTO = serviceFeign.getByIdDocument(customerService.getDocumentType());
                CustomerResponseDTO customer = new CustomerResponseDTO(
                        customerService.getId(),
                        customerService.getName(),
                        customerService.getSurname(),
                        documentDTO,
                        customerService.getDocument(),
                        customerService.getState()
                );

                customers.add(customer);
            } catch (Exception e) {
                log.error("[Error] {}: {}", customerService.getId(), e.getMessage());
            }
        });

        return customers;
    }

    public CustomerResponseDTO getById(String id) {
        CustomerDTO customerService = serviceFeign.getByIdCustomer(id);

        if (customerService != null) {
            // Search documentType
            DocumentDTO documentDTO = serviceFeign.getByIdDocument(customerService.getDocumentType());
            return new CustomerResponseDTO(
                    customerService.getId(),
                    customerService.getName(),
                    customerService.getSurname(),
                    documentDTO,
                    customerService.getDocument(),
                    customerService.getState()
            );
        }

        return null;
    }

//    public DocumentDTO save(DocumentDTO documentDTO) {
//        return documentServiceFeign.save(documentDTO);
//    }
//
//    public DocumentDTO disabledById(String id) {
//        return documentServiceFeign.disabledById(id);
//    }


}
