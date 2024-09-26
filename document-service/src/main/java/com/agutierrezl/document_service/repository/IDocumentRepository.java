package com.agutierrezl.document_service.repository;

import com.agutierrezl.document_service.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentRepository extends CrudRepository<DocumentEntity,String> {
}
