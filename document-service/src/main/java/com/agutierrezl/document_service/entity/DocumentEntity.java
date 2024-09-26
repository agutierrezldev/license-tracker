package com.agutierrezl.document_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "documents")
public class DocumentEntity {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String type;

    @Field
    private String description;

    @Field
    private Integer length;

    @Field
    private String state;
}
