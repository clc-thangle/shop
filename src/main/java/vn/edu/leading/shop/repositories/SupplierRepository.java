package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.leading.shop.models.SuppliersModel;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SuppliersModel, Long> {
    List<SuppliersModel> findBySupplierNameContaining(String term);
}