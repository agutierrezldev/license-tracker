package com.agutierrezl.license_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LicenseDTO {

    private String id;

    private String code;

    @NotNull
    private String customer;

    @NotNull
    private String category;

    @Builder.Default
    private Boolean isRenewed = false;

    @Field
    private LocalDate obtainedDate;

    @NotNull
    private LocalDate validityDate;

    @Builder.Default
    private Boolean isActive = false;

}
