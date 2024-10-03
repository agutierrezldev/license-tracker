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
public class SubCategoryDTO {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private CategoryDTO category;

    @Builder.Default
    private String state = "ACTIVO";

}
