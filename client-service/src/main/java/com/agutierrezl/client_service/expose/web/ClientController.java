package com.agutierrezl.client_service.expose.web;

import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/documents")
    public List<DocumentDTO> getAllDocuments(){
        return clientService.getAll();
    }

    @PostMapping("/documents-save")
    public DocumentDTO saveDocument(@RequestBody DocumentDTO documentDTO){
        return clientService.save(documentDTO);
    }


}
