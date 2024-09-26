package com.agutierrezl.document_service.service.impl;

import com.agutierrezl.document_service.dto.DocumentDTO;
import com.agutierrezl.document_service.entity.DocumentEntity;
import com.agutierrezl.document_service.repository.IDocumentRepository;
import com.agutierrezl.document_service.service.IDocumentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements IDocumentService {

    private final IDocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DocumentDTO update(String id, DocumentDTO documentDTO) {
        DocumentEntity document = documentRepository.findById(id).orElse(null);
        if (document != null) {
            documentDTO.setId(document.getId());
            DocumentEntity updatedDocument = convertToEntity(documentDTO);
            return convertToDTO(documentRepository.save(updatedDocument));
        }
        return null;
    }

    @Override
    public DocumentDTO save(DocumentDTO documentDTO) {
        DocumentEntity document = documentRepository.save(convertToEntity(documentDTO));
        return convertToDTO(document);
    }

    @Override
    public List<DocumentDTO> getAll() {
        List<DocumentEntity> documents = (List<DocumentEntity>) documentRepository.findAll();
        return documents.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentDTO getById(String id) {
        DocumentEntity document = documentRepository.findById(id).orElse(null);
        if (document != null) {
            return convertToDTO(document);
        }
        return null;
    }

    private DocumentDTO convertToDTO(DocumentEntity documentEntity) {
        return modelMapper.map(documentEntity, DocumentDTO.class);
    }

    private DocumentEntity convertToEntity(DocumentDTO documentDTO) {
        return modelMapper.map(documentDTO, DocumentEntity.class);
    }
}
