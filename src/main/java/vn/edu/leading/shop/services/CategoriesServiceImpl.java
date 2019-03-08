package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CategoriesModel;
import vn.edu.leading.shop.repositories.CategoriesRepository;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<CategoriesModel> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public List<CategoriesModel> search(String term) {
        return categoriesRepository.findByCategoryNameContaining(term);
    }

    @Override
    public CategoriesModel findByAId(Long id) {
        return categoriesRepository.findById(id).get();
    }

    @Override
    public boolean update(CategoriesModel category) {
        CategoriesModel categoriesModel = categoriesRepository.findById(category.getId()).orElse(null);
        if(categoriesModel==null)
        {
            return false;
        }
        categoriesRepository.save(category);
        return true;
    }

    @Override
    public void save(CategoriesModel category) {
        categoriesRepository.save(category);
    }

    @Override
    public boolean delete(Long id) {
        CategoriesModel categoriesModel = categoriesRepository.findById(id).orElse(null);
        if(categoriesModel==null)
        {
            return false;
        }
        categoriesRepository.delete(categoriesModel);
        return true;
    }
}
