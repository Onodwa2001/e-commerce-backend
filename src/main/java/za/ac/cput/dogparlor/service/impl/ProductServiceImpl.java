package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Product;
import za.ac.cput.dogparlor.repository.ProductRepository;
import za.ac.cput.dogparlor.service.IProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getProductId()))
            return productRepository.save(product);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
