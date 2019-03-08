package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.ShippersModel;

import java.util.List;

public interface ShipperService {
    List<ShippersModel> findAll();

    List<ShippersModel> search(String term);

    ShippersModel findById(Long id);

    boolean update(ShippersModel shipper);

    void save(ShippersModel shipper);

    boolean delete(Long id);
}