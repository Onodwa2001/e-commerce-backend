package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Product;

import java.util.List;

public interface IProductService extends IService<Product, String> {

    List<Product> getAllProducts();

}
