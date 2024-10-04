package com.agutierrezl.license_service.service.impl;


import com.agutierrezl.license_service.dto.LicenseDTO;
import com.agutierrezl.license_service.entity.LicenseEntity;
import com.agutierrezl.license_service.repository.ILicenseRepository;
import com.agutierrezl.license_service.service.ILicenseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements ILicenseService {

    private final ModelMapper modelMapper;
    private final ILicenseRepository licenseRepository;

    @Override
    public LicenseDTO save(LicenseDTO licenseDTO) {

        LocalDate now = LocalDate.now();
        licenseDTO.setObtainedDate(now);
        // index for date
        long countForDate = licenseRepository.countByObtainedDate(now);
        licenseDTO.setCode(Long.toString(countForDate));

        LicenseEntity license  = licenseRepository.save(convertToEntity(licenseDTO));
        return convertToDTO(license);
    }

    @Override
    public LicenseDTO update(String id, LicenseDTO licenseDTO) {
        LicenseEntity license = licenseRepository.findById(id).orElse(null);
        if (license != null) {
            licenseDTO.setId(id);
            LicenseEntity updatedDocument = convertToEntity(licenseDTO);
            return convertToDTO(licenseRepository.save(updatedDocument));
        }
        return null;
    }

    @Override
    public List<LicenseDTO> getAll() {

        List<LicenseEntity> licenses = deleteExpiredLicenses();

        return licenses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LicenseDTO getById(String id) {
        LicenseEntity license = licenseRepository.findById(id).orElse(null);
        if (license != null) {
            return convertToDTO(license);
        }
        return null;
    }

    private List<LicenseEntity>  deleteExpiredLicenses(){
        LocalDate thresholdDate = LocalDate.now().plusDays(30);

        List<LicenseEntity> licensesToDelete = licenseRepository.
                findByValidityDateAfterAndIsRenewedAndIsActive(thresholdDate, false, true);

        licensesToDelete.forEach(license -> license.setIsActive(false));

        licenseRepository.saveAll(licensesToDelete);

        return licensesToDelete;
    }


    private LicenseDTO convertToDTO(LicenseEntity licenseEntity) {
        return modelMapper.map(licenseEntity, LicenseDTO.class);
    }

    private LicenseEntity convertToEntity(LicenseDTO licenseDTO) {
        return modelMapper.map(licenseDTO, LicenseEntity.class);
    }
}
