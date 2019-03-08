package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.leading.shop.models.ShippersModel;

import java.util.List;

public interface ShipperRepository extends JpaRepository<ShippersModel, Long> {

    List<ShippersModel> findByShipperNameContaining(String term);
}