package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Address;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.Order;
import za.ac.cput.dogparlor.domain.Product;
import za.ac.cput.dogparlor.util.Helper;

import java.time.LocalDateTime;

public class OrderFactory {

    public static Order createOrder(Customer customer, Product product, double totalAmount,
                                    LocalDateTime orderDate, Address address, LocalDateTime deliveryDate,
                                    String deliveryStatus) {
        if (Helper.isNullOrEmpty(deliveryStatus)) {
            System.out.println("Delivery status is null");
            return null;
        }

        if (totalAmount < 0) {
            System.out.println("order amount is less than 0");
            return null;
        }

        if (customer == null) {
            System.out.println("Customer is null");
            return null;
        }

        if (product == null) {
            System.out.println("Product is null");
            return null;
        }

        if (address == null) {
            System.out.println("Address is null");
            return null;
        }

        String orderId = Helper.generateID();

        return new Order.Builder()
                .setOrderId(orderId)
                .setCustomer(customer)
                .setProduct(product)
                .setTotalAmount(totalAmount)
                .setOrderDate(orderDate)
                .setAddress(address)
                .setDeliveryDate(deliveryDate)
                .setDeliveryStatus(deliveryStatus)
                .build();

    }

}
