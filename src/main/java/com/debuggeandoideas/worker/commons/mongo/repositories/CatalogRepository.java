package com.debuggeandoideas.worker.commons.mongo.repositories;

import com.debuggeandoideas.worker.commons.mongo.documents.CatalogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogRepository extends MongoRepository<CatalogDocument, String> {
}