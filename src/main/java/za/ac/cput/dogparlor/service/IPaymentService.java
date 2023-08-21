package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment, String> {

    List<Payment> getAllPayments();

}
