package com.agutierrezl.client_service.proxy.openfeign;

import com.agutierrezl.client_service.model.response.DocumentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "document-service")
public interface IDocumentServiceFeign {

    @GetMapping("/documents")
    List<DocumentDTO> getAll();

    @PostMapping("/documents")
    DocumentDTO save(@RequestBody DocumentDTO documentDTO);

}
