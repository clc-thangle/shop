package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CustomerModel;

import java.util.List;
@Service
public interface CustomerService {
    List<CustomerModel> findAll();

    List<CustomerModel> search(String term);

    CustomerModel findByAId(Long id);

    boolean update(CustomerModel customer);

    void save (CustomerModel customer);

    boolean delete(Long id);
}
