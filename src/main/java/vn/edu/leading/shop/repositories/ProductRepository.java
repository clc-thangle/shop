package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.leading.shop.models.ProductsModel;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductsModel, Long> {
    List<ProductsModel> findByProductNameContaining(String term);
}