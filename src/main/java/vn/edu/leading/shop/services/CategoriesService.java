package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CategoriesModel;

import java.util.List;
@Service
public interface CategoriesService {
    List<CategoriesModel> findAll();

    List<CategoriesModel> search(String term);

    CategoriesModel findByAId(Long id);

    boolean update(CategoriesModel category);

    void save (CategoriesModel category);

    boolean delete(Long id);
}
