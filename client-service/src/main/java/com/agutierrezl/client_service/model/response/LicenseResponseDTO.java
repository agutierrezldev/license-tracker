package com.agutierrezl.client_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LicenseResponseDTO {
    private String id;
    private String code;
    private CustomerResponseDTO customer;
    private SubCategoryDTO category;
    private Boolean isRenewed;
    private LocalDate obtainedDate;
    private LocalDate validityDate;
    private Boolean isActive;
}
