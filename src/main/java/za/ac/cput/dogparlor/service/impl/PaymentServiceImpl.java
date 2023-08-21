package za.ac.cput.dogparlor.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Payment;
import za.ac.cput.dogparlor.repository.PaymentRepository;
import za.ac.cput.dogparlor.service.IPaymentService;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment read(String id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        if (paymentRepository.existsById(payment.getPaymentId()))
            return paymentRepository.save(payment);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
