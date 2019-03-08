package vn.edu.leading.shop.services;


import vn.edu.leading.shop.models.ProductsModel;

import java.util.List;

public interface ProductService {
    List<ProductsModel> findAll();

    List<ProductsModel> search(String term);

    ProductsModel findById(Long id);

    boolean update(ProductsModel product);

    void save(ProductsModel product);

    boolean delete(Long id);
}