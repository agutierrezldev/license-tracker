package com.agutierrezl.client_service.expose.web;

import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final ClientService clientService;

    @GetMapping("/documents")
    public List<DocumentDTO> getAllDocuments(){
        return clientService.getAll();
    }

    @GetMapping("/documents/{id}")
    public DocumentDTO getById(@PathVariable String id){
        return clientService.getById(id);
    }

    @PostMapping("/documents-save")
    public DocumentDTO saveDocument(@RequestBody DocumentDTO documentDTO){
        return clientService.save(documentDTO);
    }

    @GetMapping("/documents-disabled/{id}")
    public DocumentDTO disabledById(@PathVariable String id){
        return clientService.disabledById(id);
    }


}
