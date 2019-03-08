package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.SuppliersModel;

import java.util.List;

public interface SupplierService {
    List<SuppliersModel> findAll();

    List<SuppliersModel> search(String term);

    SuppliersModel findById(Long id);

    boolean update(SuppliersModel supplier);

    void save(SuppliersModel supplier);

    boolean delete(Long id);
}