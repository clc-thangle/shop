package vn.edu.leading.shop.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.ShippersModel;
import vn.edu.leading.shop.repositories.ShipperRepository;

import java.util.List;

@Repository
@Service

public class ShipperServicelmpl implements ShipperService {
    private final ShipperRepository shipperRepository;

    public ShipperServicelmpl(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @Override
    public List<ShippersModel> findAll() {
        return shipperRepository.findAll();
    }

    @Override
    public List<ShippersModel> search(String term) {
        return shipperRepository.findByShipperNameContaining(term);
    }

    @Override
    public ShippersModel findById(Long id) {
        return shipperRepository.findById(id).get();
    }

    @Override
    public boolean update(ShippersModel shipper) {
        ShippersModel shipperModel = shipperRepository.findById(shipper.getId()).orElse(null);
        if (shipperModel == null)
            return false;
        shipperRepository.delete(shipperModel);
        return true;
    }

    @Override
    public void save(ShippersModel shipper) {
        shipperRepository.save(shipper);
    }

    @Override
    public boolean delete(Long id) {
        ShippersModel shipperModel = shipperRepository.findById(id).orElse(null);
        if (shipperModel == null)
            return false;
        shipperRepository.delete(shipperModel);
        return true;
    }
}