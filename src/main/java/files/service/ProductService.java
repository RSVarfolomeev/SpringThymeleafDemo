package files.service;


import files.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Product findById(long id);
    void deleteById(long id);
    void save(Product product);
}
