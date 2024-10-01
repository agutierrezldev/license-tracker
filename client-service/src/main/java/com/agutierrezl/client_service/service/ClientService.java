package com.agutierrezl.client_service.service;

import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.proxy.openfeign.ICloudGatewayFeign;
import com.agutierrezl.client_service.proxy.openfeign.IDocumentServiceFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    // private final IDocumentServiceFeign documentServiceFeign;
    private final ICloudGatewayFeign documentServiceFeign;

    public List<DocumentDTO> getAll(){
        return documentServiceFeign.getAll();
    }

    public DocumentDTO save(@RequestBody DocumentDTO documentDTO){
        return documentServiceFeign.save(documentDTO);
    }


}
