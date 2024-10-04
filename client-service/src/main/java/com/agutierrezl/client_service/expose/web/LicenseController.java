package com.agutierrezl.client_service.expose.web;

import com.agutierrezl.client_service.model.response.CustomerResponseDTO;
import com.agutierrezl.client_service.model.response.LicenseDTO;
import com.agutierrezl.client_service.model.response.LicenseResponseDTO;
import com.agutierrezl.client_service.service.CustomerService;
import com.agutierrezl.client_service.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;

//    @GetMapping("/licenses")
//    public List<CustomerResponseDTO> getAllCustomers(){
//        return customerService.getAll();
//    }

    @GetMapping("/licenses/{id}")
    public LicenseResponseDTO getById(@PathVariable String id) {
        return licenseService.getById(id);
    }

    @PostMapping("/licenses-save")
    public LicenseDTO save(@RequestBody LicenseDTO licenseDTO) {
        return licenseService.save(licenseDTO);
    }


}
