package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Product;
import za.ac.cput.dogparlor.util.Helper;

public class ProductFactory {

    public static Product createProduct(String productName, double cost, String imageURL,
                                        String description) {
        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(description)) {
            System.out.println("Product name or description is null or empty");
            return null;
        }

        if (cost < 0) {
            System.out.println("Product cost is less than zero");
            return null;
        }

        String productId = Helper.generateID();

        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setCost(cost)
                .setImageURL(imageURL)
                .setDescription(description)
                .build();
    }

}
