package com.agutierrezl.client_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponseDTO {
    private String id;
    private String name;
    private String surname;
    private DocumentDTO documentType;
    private String document;
    private String state;
}
