package com.agutierrezl.document_service.service;

import com.agutierrezl.document_service.dto.DocumentDTO;
import java.util.List;

public interface IDocumentService {

    DocumentDTO update(String id, DocumentDTO documentDTO);
    DocumentDTO save(DocumentDTO documentDTO);
    List<DocumentDTO> getAll();
    DocumentDTO getById(String id);
    DocumentDTO disabledById(String id);

}
