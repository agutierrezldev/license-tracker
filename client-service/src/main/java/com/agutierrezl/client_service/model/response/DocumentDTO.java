package com.agutierrezl.client_service.model.response;

import lombok.Data;

@Data
public class DocumentDTO {
    private String id;
    private String name;
    private String type;
    private String description;
    private Integer length;
    private String state;
}
