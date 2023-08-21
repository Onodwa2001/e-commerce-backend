package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Order;
import za.ac.cput.dogparlor.domain.Payment;
import za.ac.cput.dogparlor.util.Helper;

public class PaymentFactory {

//    public String paymentId;
//    private Order order;
//    private boolean paid;
//    private double amount;
//    private String paymentMethod;

    public static Payment createPayment(Order order, boolean paid,
                                        double amount, String paymentMethod) {
        if (amount < 0) {
            System.out.println("Amount is less than zero");
            return null;
        }

        if (Helper.isNullOrEmpty(paymentMethod)) {
            System.out.println("payment method is null or empty");
            return null;
        }

        String paymentId = Helper.generateID();

        return  new Payment.Builder()
                .setPaymentId(paymentId)
                .setOrderProduct(order)
                .setPaid(paid)
                .setAmount(amount)
                .setPaymentMethod(paymentMethod)
                .build();
    }

}
