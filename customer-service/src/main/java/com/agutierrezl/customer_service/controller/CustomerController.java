package com.agutierrezl.customer_service.controller;

import com.agutierrezl.customer_service.dto.CustomerDTO;
import com.agutierrezl.customer_service.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<DocumentDTO> update(@PathVariable String id, @Valid @RequestBody DocumentDTO documentDTO) {
//        return ResponseEntity.ok(documentService.update(id, documentDTO));
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping("/disabled/{id}")
    public ResponseEntity<CustomerDTO> disabledById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.disabledById(id));
    }

    @GetMapping("/enabled/{id}")
    public ResponseEntity<CustomerDTO> enabledById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.enabledById(id));
    }

    @GetMapping("/enabled")
    public ResponseEntity<List<CustomerDTO>> findAllEnabled() {
        return ResponseEntity.ok(customerService.findAllEnabled());
    }
}
