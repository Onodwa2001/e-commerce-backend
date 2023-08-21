package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.springframework.context.annotation.Profile;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {

    @Id
    private String productId;
    private String productName;
    private double cost;
    private String imageURL;
    @Column(length = 3000)
    private String description;

    protected Product() {}

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.cost = builder.cost;
        this.imageURL = builder.imageURL;
        this.description = builder.description;
    }


    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getCost() {
        return cost;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 && Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(imageURL, product.imageURL) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, cost, imageURL, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", cost=" + cost +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {

        private String productId;
        private String productName;
        private double cost;
        private String imageURL;
        private String description;

        public Builder() {}

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setCost(double cost) {
            this.cost = cost;
            return this;
        }

        public Builder setImageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Product product) {
            this.productId = product.productId;
            this.productName = product.productName;
            this.cost = product.cost;
            this.imageURL = product.imageURL;
            this.description = product.description;
            return this;
        }

        public Product build() { return new Product(this); }

    }

}
