package com.debuggeandoideas.worker.commons.mongo.repositories;

import com.debuggeandoideas.worker.commons.mongo.documents.ProductInCatalogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInCatalogRepository extends MongoRepository<ProductInCatalogDocument, String> {

}