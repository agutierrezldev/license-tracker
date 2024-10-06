package com.agutierrezl.document_service.controller;

import com.agutierrezl.document_service.dto.DocumentDTO;
import com.agutierrezl.document_service.service.IDocumentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/documents")
@OpenAPIDefinition(
        info = @Info(
                title = "document-service",
                version = "0.0.1-SNAPSHOT",
                description = "Document Service for project: license-tracker",
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
                @Server(url = "http://localhost:9020", description = "Instance 1"),
                // @Server(url = "http://localhost:9021", description = "Instance 2")
        },
        tags = {
                @Tag(name = "DocumentQuery", description = "Endpoints para manipular datos en modo lectura"), //GET
                @Tag(name = "DocumentCommand", description = "Endpoints para manipular datos en modo escritura") // POST, PUT, DELETE , PATCH
        }
)
// @CrossOrigin(maxAge = 3600, origins = "http://localhost")
public class DocumentController {

    private final IDocumentService documentService;

    @Operation(
            description = "Get all documents",
            tags = {"DocumentQuery"},
            responses = {
                    @ApiResponse(description = "Response OK", responseCode = "200"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = HttpServerErrorException.InternalServerError.class))
                        // content = @Content(schema = @Schema(implementation = String.class)) // string
                            // array
//                            content = @Content(array = @ArraySchema(
//                                    schema = @Schema(implementation = ErrorResponse.class)
//                            ))
                    )
            }
    )
    @GetMapping("")
    public ResponseEntity<List<DocumentDTO>> getAll() {
        return ResponseEntity.ok(documentService.getAll());
    }

    @Operation(tags = "DocumentCommand", description = "Save a new document",
            responses = {
                    @ApiResponse(description = "Document created", responseCode = "201",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocumentDTO.class))),
                    @ApiResponse(description = "Invalid request data", responseCode = "400",
                            content = @Content(mediaType = "application/json"))
            }
    )
    @PostMapping("")
    public ResponseEntity<DocumentDTO> save(@Valid @RequestBody DocumentDTO documentDTO) {
        return ResponseEntity.ok(documentService.save(documentDTO));
    }

    @Operation(
            summary = "Update an existing document by ID",
            description = "Updates the data of a specific document using its ID",
            tags = {"DocumentCommand"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Document successfully updated",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DocumentDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request, invalid data",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Document not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<DocumentDTO> update(@PathVariable String id, @Valid @RequestBody DocumentDTO documentDTO) {
        return ResponseEntity.ok(documentService.update(id, documentDTO));
    }

    @Operation(
            summary = "Get a document by ID",
            description = "Returns the details of a specific document using its ID",
            tags = {"DocumentQuery"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Document successfully retrieved",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DocumentDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Document not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(documentService.getById(id));
    }

    @Operation(
            summary = "Disable a document by ID",
            description = "Disables a specific document using its ID",
            tags = {"DocumentQuery"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Document successfully disabled",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DocumentDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Document not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/disabled/{id}")
    public ResponseEntity<DocumentDTO> disabledById(@PathVariable String id) {
        return ResponseEntity.ok(documentService.disabledById(id));
    }

}