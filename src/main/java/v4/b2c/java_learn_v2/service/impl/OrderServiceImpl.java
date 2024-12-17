package v4.b2c.java_learn_v2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import v4.b2c.java_learn_v2.dto.OrderAndPaymentRequest;
import v4.b2c.java_learn_v2.entity.Payment;
import v4.b2c.java_learn_v2.repository.OrderRepository;
import v4.b2c.java_learn_v2.repository.PaymentRepository;
import v4.b2c.java_learn_v2.service.OrderService;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public String processOrder(OrderAndPaymentRequest request) {
        validateAndSaveOrder(request);
        validateAndSavePayment(request);

        return "SUCCESS Create transaction, description: " + request.getOrderDescription() +
                ", paymentAmount : " + request.getPaymentAmount();
    }

    private void validateAndSaveOrder(OrderAndPaymentRequest request){
        v4.b2c.java_learn_v2.entity.Order order = new v4.b2c.java_learn_v2.entity.Order();
        order.setDescription(request.getOrderDescription());
        orderRepository.save(order);
    }

    private void validateAndSavePayment(OrderAndPaymentRequest request){
        Payment payment = new Payment();
        payment.setAmount(request.getPaymentAmount());
        paymentRepository.save(payment);

        if (payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
    }
}
