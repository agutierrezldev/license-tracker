package com.agutierrezl.client_service.proxy.openfeign;

import com.agutierrezl.client_service.model.response.DocumentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "cloud-gateway")
public interface ICloudGatewayFeign {

    @GetMapping("/api/document-service/documents")
    List<DocumentDTO> getAll();

    @PostMapping("/api/document-service/documents")
    DocumentDTO save(DocumentDTO documentDTO);
}
