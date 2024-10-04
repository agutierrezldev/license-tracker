package com.agutierrezl.client_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LicenseDTO {
    private String id;
    private String code;
    private String customer;
    private String category;
    private Boolean isRenewed;
    private LocalDate obtainedDate;
    private LocalDate validityDate;
    private Boolean isActive;

}
