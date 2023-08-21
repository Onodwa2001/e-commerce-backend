package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="Order_table")
public class Order implements Serializable {

    @Id
    private String orderId;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Product product;
    private double totalAmount;
    private LocalDateTime orderDate;
    @OneToOne
    private Address address;
    private LocalDateTime deliveryDate;
    private String deliveryStatus;

    protected Order() {}

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.customer = builder.customer;
        this.product = builder.product;
        this.totalAmount = builder.totalAmount;
        this.orderDate = builder.orderDate;
        this.address = builder.address;
        this.deliveryDate = builder.deliveryDate;
        this.deliveryStatus = builder.deliveryStatus;
    }


    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalAmount, totalAmount) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(customer, order.customer) && Objects.equals(product, order.product) && Objects.equals(orderDate, order.orderDate) && Objects.equals(address, order.address) && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(deliveryStatus, order.deliveryStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, product, totalAmount, orderDate, address, deliveryDate, deliveryStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer=" + customer +
                ", product=" + product +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                ", address=" + address +
                ", deliveryDate=" + deliveryDate +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                '}';
    }

    public static class Builder {

        private String orderId;
        private Customer customer;
        private Product product;
        private double totalAmount;
        private LocalDateTime orderDate;
        private Address address;
        private LocalDateTime deliveryDate;
        private String deliveryStatus;

        public Builder() {}

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setDeliveryDate(LocalDateTime deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
            return this;
        }



        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.customer = order.customer;
            this.product = order.product;
            this.totalAmount = order.totalAmount;
            this.orderDate = order.orderDate;
            this.address = order.address;
            this.deliveryDate = order.deliveryDate;
            this.deliveryStatus = order.deliveryStatus;
            return this;
        }

        public Order build() { return new Order(this); }

    }

}
