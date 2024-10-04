package com.agutierrezl.license_service.repository;

import com.agutierrezl.license_service.entity.LicenseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILicenseRepository extends CrudRepository<LicenseEntity,String> {
    long countByObtainedDate(LocalDate obtainedDate);

    List<LicenseEntity> findByValidityDateAfterAndIsRenewedAndIsActive(LocalDate validityDate, boolean isRenewed, boolean isActive);
}
