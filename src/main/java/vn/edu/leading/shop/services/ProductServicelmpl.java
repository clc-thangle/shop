package vn.edu.leading.shop.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.ProductsModel;
import vn.edu.leading.shop.repositories.ProductRepository;

import java.util.List;

@Repository
@Service
public class ProductServicelmpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServicelmpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductsModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductsModel> search(String term) {
        return productRepository.findByProductNameContaining(term);
    }

    @Override
    public ProductsModel findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public boolean update(ProductsModel product) {
        ProductsModel productModel = productRepository.findById(product.getId()).orElse(null);
        if (productModel == null)
            return false;
        productRepository.delete(productModel);
        return true;
    }

    @Override
    public void save(ProductsModel product) {
        productRepository.save(product);
    }

    @Override
    public boolean delete(Long id) {
        ProductsModel productModel = productRepository.findById(id).orElse(null);
        if (productModel == null)
            return false;
        productRepository.delete(productModel);
        return true;
    }
}