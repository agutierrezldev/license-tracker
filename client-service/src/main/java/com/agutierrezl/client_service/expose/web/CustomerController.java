package com.agutierrezl.client_service.expose.web;

import com.agutierrezl.client_service.model.response.CustomerResponseDTO;
import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerResponseDTO> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getById(@PathVariable String id){
        return customerService.getById(id);
    }

//    @PostMapping("/documents-save")
//    public DocumentDTO saveDocument(@RequestBody DocumentDTO documentDTO){
//        return clientService.save(documentDTO);
//    }
//
//    @GetMapping("/documents-disabled/{id}")
//    public DocumentDTO disabledById(@PathVariable String id){
//        return clientService.disabledById(id);
//    }


}
