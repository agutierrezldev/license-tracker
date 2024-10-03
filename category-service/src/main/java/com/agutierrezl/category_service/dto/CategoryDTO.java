package com.agutierrezl.category_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @Builder.Default
    private String state = "ACTIVO";

}
