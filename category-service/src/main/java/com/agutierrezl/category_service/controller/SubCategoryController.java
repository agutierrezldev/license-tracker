package com.agutierrezl.category_service.controller;

import com.agutierrezl.category_service.dto.SubCategoryDTO;
import com.agutierrezl.category_service.service.ISubCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    private final ISubCategoryService subcategoryService;

    @Operation(
            summary = "Get all subcategories",
            description = "Returns a list of all subcategories",
            tags = {"SubCategoryQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of subcategories",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SubCategoryDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("")
    public ResponseEntity<List<SubCategoryDTO>> getAll() {
        return ResponseEntity.ok(subcategoryService.getAll());
    }

    @Operation(
            summary = "Create a new subcategory",
            description = "Creates a new subcategory with the given details",
            tags = {"SubCategoryCommand"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Subcategory successfully created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SubCategoryDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid data"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping("")
    public ResponseEntity<SubCategoryDTO> save(@Valid @RequestBody SubCategoryDTO subcategoryDTO) {
        return ResponseEntity.ok(subcategoryService.save(subcategoryDTO));
    }

    @Operation(
            summary = "Update subcategory by ID",
            description = "Updates an existing subcategory with the provided details using its ID",
            tags = {"SubCategoryCommand"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Subcategory successfully updated",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SubCategoryDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid data"),
                    @ApiResponse(responseCode = "404", description = "Subcategory not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<SubCategoryDTO> update(@PathVariable String id, @Valid @RequestBody SubCategoryDTO subcategoryDTO) {
        return ResponseEntity.ok(subcategoryService.update(id, subcategoryDTO));
    }

    @Operation(
            summary = "Get subcategory by ID",
            description = "Fetches a specific subcategory using its ID",
            tags = {"SubCategoryQuery"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Subcategory found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SubCategoryDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Subcategory not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(subcategoryService.getById(id));
    }
}
