package com.agutierrezl.client_service.service;

import com.agutierrezl.client_service.model.response.*;
import com.agutierrezl.client_service.proxy.openfeign.ICloudGatewayServiceFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LicenseService {

    private final ICloudGatewayServiceFeign serviceFeign;

    private final CustomerService customerService;
    private final SubCategoryService subcategoryService;

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

    public LicenseResponseDTO getById(String id) {
        LicenseDTO licenseService = serviceFeign.getByIdLicense(id);

        if (licenseService != null) {
            // Search customer
            CustomerResponseDTO customerDTO = customerService.getById(licenseService.getCustomer());
            SubCategoryDTO subCategoryDTO = subcategoryService.getById(licenseService.getCategory());
            return new LicenseResponseDTO(
                    licenseService.getId(),
                    getCodeByLicense(licenseService, subCategoryDTO),
                    customerDTO,
                    subCategoryDTO,
                    licenseService.getIsRenewed(),
                    licenseService.getObtainedDate(),
                    licenseService.getValidityDate(),
                    licenseService.getIsActive()
            );
        }

        return null;
    }

    public LicenseDTO save(LicenseDTO licenseDTO) {
        return serviceFeign.saveLicense(licenseDTO);
    }


    private String getCodeByLicense(LicenseDTO licenseDTO, SubCategoryDTO subCategoryDTO) {
        String init = "LIC";

        String formattedDate = licenseDTO.getObtainedDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        int suffix = (int) (Integer.parseInt(licenseDTO.getCode()) + 1);
        String formattedSuffix = String.format("%03d", suffix); // example 001

        return init.concat(subCategoryDTO.getCategory().getName())
                .concat(subCategoryDTO.getName())
                .concat(formattedDate)
                .concat("-")
                .concat(formattedSuffix);
    }
//
//    public DocumentDTO disabledById(String id) {
//        return documentServiceFeign.disabledById(id);
//    }


}
