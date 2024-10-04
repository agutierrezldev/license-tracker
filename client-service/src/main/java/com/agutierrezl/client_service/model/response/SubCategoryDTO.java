package com.agutierrezl.client_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDTO {
    private String id;
    private String name;
    private String description;
    private CategoryDTO category;
    private String state;

}
