package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Payment implements Serializable {

    @Id
    private String paymentId;
    @OneToOne
    private Order orderProduct;
    private boolean paid;
    private double amount;
    private String paymentMethod;

    protected Payment() {}

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.orderProduct = builder.orderProduct;
        this.paid = builder.paid;
        this.amount = builder.amount;
        this.paymentMethod = builder.paymentMethod;
    }


    public String getPaymentId() {
        return paymentId;
    }

    public Order getOrderProduct() {
        return orderProduct;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paid == payment.paid && Double.compare(payment.amount, amount) == 0 && Objects.equals(paymentId, payment.paymentId) && Objects.equals(orderProduct, payment.orderProduct) && Objects.equals(paymentMethod, payment.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, orderProduct, paid, amount, paymentMethod);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", order=" + orderProduct +
                ", paid=" + paid +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public static class Builder {

        public String paymentId;
        private Order orderProduct;
        private boolean paid;
        private double amount;
        private String paymentMethod;

        public Builder() {}

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setOrderProduct(Order orderProduct) {
            this.orderProduct = orderProduct;
            return this;
        }

        public Builder setPaid(boolean paid) {
            this.paid = paid;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.orderProduct = payment.orderProduct;
            this.paid = payment.paid;
            this.amount = payment.amount;
            this.paymentMethod = payment.paymentMethod;
            return this;
        }

        public Payment build() { return new Payment(this); }
    }

}
