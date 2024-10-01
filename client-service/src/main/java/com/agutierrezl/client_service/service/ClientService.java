package com.agutierrezl.client_service.service;

import com.agutierrezl.client_service.model.response.DocumentDTO;
import com.agutierrezl.client_service.proxy.openfeign.ICloudGatewayServiceFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    // private final IDocumentServiceFeign documentServiceFeign;
    private final ICloudGatewayServiceFeign documentServiceFeign;

    public List<DocumentDTO> getAll(){
        return documentServiceFeign.getAllDocuments();
    }

    public DocumentDTO getById(String id){
        return documentServiceFeign.getByIdDocument(id);
    }

    public DocumentDTO save(DocumentDTO documentDTO){
        return documentServiceFeign.saveDocument(documentDTO);
    }

    public DocumentDTO disabledById(String id){
        return documentServiceFeign.disabledByIdDocument(id);
    }


}
