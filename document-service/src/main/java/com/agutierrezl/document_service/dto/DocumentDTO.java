package com.agutierrezl.document_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Builder.Default
    private String state = "ACTIVO";

}
