package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.CategoriesModel;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesModel,Long>{
    List<CategoriesModel> findByCategoryNameContaining(String term);
}
