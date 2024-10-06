package com.agutierrezl.customer_service.controller;

import com.agutierrezl.customer_service.dto.CustomerDTO;
import com.agutierrezl.customer_service.service.ICustomerService;
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
@RequestMapping("/customers")
@OpenAPIDefinition(
        info = @Info(
                title = "customer-service",
                version = "0.0.1-SNAPSHOT",
                description = "Customer Service for project: license-tracker",
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
        servers = @Server(url = "http://localhost:9021"),
        tags = {
                @Tag(name = "CustomerQuery", description = "Customer management endpoints - read"),
                @Tag(name = "CustomerCommand", description = "Customer management endpoints - write")
        }
)
public class CustomerController {

    private final ICustomerService customerService;

    @Operation(
            summary = "Get all customers",
            description = "Returns a list of all customers",
            tags = {"CustomerQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of customers",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @Operation(
            summary = "Create a new customer",
            description = "Creates a new customer with the given details",
            tags = {"CustomerCommand"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Customer successfully created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid data"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("")
    public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @Operation(
            summary = "Get customer by ID",
            description = "Fetches a specific customer using their ID",
            tags = {"CustomerQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Customer found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Customer not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @Operation(
            summary = "Disable customer by ID",
            description = "Disables a specific customer using their ID",
            tags = {"CustomerQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Customer successfully disabled",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Customer not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/disabled/{id}")
    public ResponseEntity<CustomerDTO> disabledById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.disabledById(id));
    }

    @Operation(
            summary = "Enable customer by ID",
            description = "Enables a specific customer using their ID",
            tags = {"CustomerQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Customer successfully enabled",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Customer not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/enabled/{id}")
    public ResponseEntity<CustomerDTO> enabledById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.enabledById(id));
    }

    @Operation(
            summary = "Get all enabled customers",
            description = "Returns a list of all enabled customers",
            tags = {"CustomerQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of enabled customers",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/enabled")
    public ResponseEntity<List<CustomerDTO>> findAllEnabled() {
        return ResponseEntity.ok(customerService.findAllEnabled());
    }
}
