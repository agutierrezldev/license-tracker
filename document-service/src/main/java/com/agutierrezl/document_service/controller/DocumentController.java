package com.agutierrezl.document_service.controller;

import com.agutierrezl.document_service.dto.DocumentDTO;
import com.agutierrezl.document_service.service.IDocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final IDocumentService documentService;

    @GetMapping("")
    public ResponseEntity<List<DocumentDTO>> getAll() {
        return ResponseEntity.ok(documentService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<DocumentDTO> save(@Valid @RequestBody DocumentDTO documentDTO) {
        return ResponseEntity.ok(documentService.save(documentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentDTO> update(@PathVariable String id, @Valid @RequestBody DocumentDTO documentDTO) {
        return ResponseEntity.ok(documentService.update(id, documentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(documentService.getById(id));
    }

    @GetMapping("/disabled/{id}")
    public ResponseEntity<DocumentDTO> disabledById(@PathVariable String id) {
        return ResponseEntity.ok(documentService.disabledById(id));
    }

}