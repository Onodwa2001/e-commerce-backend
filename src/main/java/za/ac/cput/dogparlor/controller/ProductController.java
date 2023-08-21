package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Product;
import za.ac.cput.dogparlor.factory.ProductFactory;
import za.ac.cput.dogparlor.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        Product createdProduct = ProductFactory.createProduct(product.getProductName(), product.getCost(),
                product.getImageURL(), product.getDescription());

        return productService.create(createdProduct);
    }

    @GetMapping("/read/{id}")
    public Product read(@PathVariable String id) {
        return productService.read(id);
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return productService.delete(id);
    }

    @GetMapping("/get-all-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
