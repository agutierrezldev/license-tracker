package com.agutierrezl.license_service.service;


import com.agutierrezl.license_service.dto.LicenseDTO;

import java.util.List;

public interface ILicenseService {
    //    SubCategoryDTO update(String id, SubCategoryDTO subcategoryDTO);
    LicenseDTO save(LicenseDTO licenseDTO);

    LicenseDTO update(String id, LicenseDTO licenseDTO);

    List<LicenseDTO> getAll();

    LicenseDTO getById(String id);
//    SubCategoryDTO enabledById(String id);
}
