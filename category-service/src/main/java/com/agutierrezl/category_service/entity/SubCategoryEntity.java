package com.agutierrezl.category_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "subcategories")
public class SubCategoryEntity {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Field
    private String name;

    @Field
    private String description;

    @Field
    private CategoryEntity category;

    @Field
    private String state;
}
