package com.agutierrezl.category_service.controller;

import com.agutierrezl.category_service.dto.CategoryDTO;
import com.agutierrezl.category_service.service.ICategoryService;
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
@RequestMapping("/categories")
@OpenAPIDefinition(
        info = @Info(
                title = "category-service",
                version = "0.0.1-SNAPSHOT",
                description = "Category Service for project: license-tracker",
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
        servers = @Server(url = "http://localhost:9022"),
        tags = {
                @Tag(name = "CategoryQuery", description = "Category management endpoints - read"),
                @Tag(name = "CategoryCommand", description = "Category management endpoints - write"),

                @Tag(name = "SubCategoryQuery", description = "SubCategory management endpoints - read"),
                @Tag(name = "SubCategoryCommand", description = "Category management endpoints - write"),
        }
)
public class CategoryController {

    private final ICategoryService categoryService;

    @Operation(
            summary = "Get all categories",
            description = "Returns a list of all categories",
            tags = {"CategoryQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of categories",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @Operation(
            summary = "Create a new category",
            description = "Creates a new category with the given details",
            tags = {"CategoryCommand"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category successfully created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid data"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("")
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO CategoryDTO) {
        return ResponseEntity.ok(categoryService.save(CategoryDTO));
    }

    @Operation(
            summary = "Get category by ID",
            description = "Fetches a specific category using its ID",
            tags = {"CategoryQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Category not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @Operation(
            summary = "Disable category by ID",
            description = "Disables a specific category using its ID",
            tags = {"CategoryQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category successfully disabled",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Category not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/disabled/{id}")
    public ResponseEntity<CategoryDTO> disabledById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.disabledById(id));
    }

    @Operation(
            summary = "Enable category by ID",
            description = "Enables a specific category using its ID",
            tags = {"CategoryQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category successfully enabled",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Category not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/enabled/{id}")
    public ResponseEntity<CategoryDTO> enabledById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.enabledById(id));
    }

    @Operation(
            summary = "Get all enabled categories",
            description = "Returns a list of all categories that are currently enabled",
            tags = {"CategoryQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of enabled categories",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/enabled")
    public ResponseEntity<List<CategoryDTO>> findAllEnabled() {
        return ResponseEntity.ok(categoryService.findAllEnabled());
    }
}
