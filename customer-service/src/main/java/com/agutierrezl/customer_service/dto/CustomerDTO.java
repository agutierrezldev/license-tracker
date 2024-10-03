package com.agutierrezl.customer_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String documentType;

    @NotNull
    private String document;

    @Builder.Default
    private String state = "ACTIVO";
}
