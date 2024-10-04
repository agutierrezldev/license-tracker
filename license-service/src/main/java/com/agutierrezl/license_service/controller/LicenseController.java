package com.agutierrezl.license_service.controller;

import com.agutierrezl.license_service.dto.LicenseDTO;
import com.agutierrezl.license_service.service.ILicenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/licenses")
public class LicenseController {

    private final ILicenseService licenseService;

    @GetMapping("")
    public ResponseEntity<List<LicenseDTO>> getAll() {
        return ResponseEntity.ok(licenseService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<LicenseDTO> save(@Valid @RequestBody LicenseDTO licenseDTO) {
        return ResponseEntity.ok(licenseService.save(licenseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LicenseDTO> update(@PathVariable String id, @Valid @RequestBody LicenseDTO licenseDTO) {
        return ResponseEntity.ok(licenseService.update(id, licenseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LicenseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(licenseService.getById(id));
    }
//
//    @GetMapping("/disabled/{id}")
//    public ResponseEntity<CategoryDTO> disabledById(@PathVariable String id) {
//        return ResponseEntity.ok(categoryService.disabledById(id));
//    }
//
//    @GetMapping("/enabled/{id}")
//    public ResponseEntity<CategoryDTO> enabledById(@PathVariable String id) {
//        return ResponseEntity.ok(categoryService.enabledById(id));
//    }
//
//    @GetMapping("/enabled")
//    public ResponseEntity<List<CategoryDTO>> findAllEnabled() {
//        return ResponseEntity.ok(categoryService.findAllEnabled());
//    }
}
