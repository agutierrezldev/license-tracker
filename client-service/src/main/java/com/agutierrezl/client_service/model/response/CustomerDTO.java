package com.agutierrezl.client_service.model.response;

import lombok.Data;
@Data
public class CustomerDTO {
    private String id;
    private String name;
    private String surname;
    private String documentType;
    private String document;
    private String state;
}
