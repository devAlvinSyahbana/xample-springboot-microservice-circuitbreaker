package tsgitsdev.com.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tsgitsdev.com.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
