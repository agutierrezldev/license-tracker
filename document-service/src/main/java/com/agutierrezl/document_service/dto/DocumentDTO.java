package com.agutierrezl.document_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String description;

    @NotNull
    private Integer length;

    private String state;

}
