package vn.edu.leading.shop.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.SuppliersModel;
import vn.edu.leading.shop.repositories.SupplierRepository;

import java.util.List;

@Repository
@Service

public class SupplierServicelmpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServicelmpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SuppliersModel> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public List<SuppliersModel> search(String term) {
        return supplierRepository.findBySupplierNameContaining(term);
    }

    @Override
    public SuppliersModel findById(Long id) {
        return supplierRepository.findById(id).get();
    }

    @Override
    public boolean update(SuppliersModel supplier) {
        SuppliersModel supplierModel = supplierRepository.findById(supplier.getId()).orElse(null);
        if (supplierModel == null)
            return false;
        supplierRepository.delete(supplierModel);
        return true;
    }

    @Override
    public void save(SuppliersModel supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public boolean delete(Long id) {
        SuppliersModel supplierModel = supplierRepository.findById(id).orElse(null);
        if (supplierModel == null)
            return false;
        supplierRepository.delete(supplierModel);
        return true;
    }
}