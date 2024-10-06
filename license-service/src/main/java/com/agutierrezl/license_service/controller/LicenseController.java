package com.agutierrezl.license_service.controller;

import com.agutierrezl.license_service.dto.LicenseDTO;
import com.agutierrezl.license_service.service.ILicenseService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/licenses")
@OpenAPIDefinition(
        info = @Info(
                title = "license-service",
                version = "0.0.1-SNAPSHOT",
                description = "License Service for project: license-tracker",
                contact = @Contact(
                        name = "Axel Gutierrez Lopez",
                        email = "axelgutierrezlopezdev@gmail.com",
                        url = "https://github.com/agutierrezldev"
                ),
                license = @License(
                        url = "https://github.com/agutierrezldev",
                        name = "Some License"
                )
        ),
        servers = {
                @Server(url = "http://localhost:9023", description = "Instance 1"),
                // @Server(url = "http://localhost:9021", description = "Instance 2")
        },
        tags = {
                @Tag(name = "LicenseQuery", description = "Endpoints para manipular datos en modo lectura"), //GET
                @Tag(name = "LicenseCommand", description = "Endpoints para manipular datos en modo escritura") // POST, PUT, DELETE , PATCH
        }
)
public class LicenseController {

    private final ILicenseService licenseService;

    @Operation(
            summary = "Get all licenses",
            description = "Returns a list of all licenses",
            tags = {"LicenseQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of licenses",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LicenseDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("")
    public ResponseEntity<List<LicenseDTO>> getAll() {
        return ResponseEntity.ok(licenseService.getAll());
    }

    @Operation(
            summary = "Create a new license",
            description = "Creates a new license with the given details",
            tags = {"LicenseCommand"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "License successfully created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LicenseDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid data"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("")
    public ResponseEntity<LicenseDTO> save(@Valid @RequestBody LicenseDTO licenseDTO) {
        return ResponseEntity.ok(licenseService.save(licenseDTO));
    }

    @Operation(
            summary = "Update license by ID",
            description = "Updates the details of a specific license using its ID",
            tags = {"LicenseCommand"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "License successfully updated",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LicenseDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid data"),
                    @ApiResponse(responseCode = "404", description = "License not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<LicenseDTO> update(@PathVariable String id, @Valid @RequestBody LicenseDTO licenseDTO) {
        return ResponseEntity.ok(licenseService.update(id, licenseDTO));
    }

    @Operation(
            summary = "Get license by ID",
            description = "Fetches a specific license using its ID",
            tags = {"LicenseQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "License found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LicenseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "License not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<LicenseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(licenseService.getById(id));
    }
}
