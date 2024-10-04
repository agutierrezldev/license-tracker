package com.agutierrezl.license_service.entity;

import com.agutierrezl.license_service.dto.LicenseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "licenses")
public class LicenseEntity {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Field
    private String code;

    @Field
    private String customer;

    @Field
    private String category;

    @Field
    private Boolean isRenewed;

    @Field
    private LocalDate obtainedDate;

    @Field
    private LocalDate validityDate;

    @Field
    private Boolean isActive;


}
