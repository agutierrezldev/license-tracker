package com.agutierrezl.client_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentDTO {
    private String id;
    private String name;
    private String type;
    private String description;
    private Integer length;
    private String state;
}
