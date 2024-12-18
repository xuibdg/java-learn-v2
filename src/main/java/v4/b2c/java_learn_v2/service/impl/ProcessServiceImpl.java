package v4.b2c.java_learn_v2.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import v4.b2c.java_learn_v2.dto.OrderAndPaymentRequest;
import v4.b2c.java_learn_v2.entity.Order;
import v4.b2c.java_learn_v2.entity.Payment;
import v4.b2c.java_learn_v2.repository.OrderRepository;
import v4.b2c.java_learn_v2.repository.PaymentRepository;

import java.math.BigDecimal;

@Slf4j
@Service
public class ProcessServiceImpl {
    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private PaymentRepository paymentRepository;

    //@Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void validateAndSaveOrder(OrderAndPaymentRequest request) {
        Order order = new Order();
        order.setDescription(request.getOrderDescription());
        orderRepository.save(order);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void validateAndSavePayment(OrderAndPaymentRequest request) {
        Payment payment = new Payment();
        payment.setAmount(request.getPaymentAmount());
        paymentRepository.save(payment);

        if (payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String createOrder(OrderAndPaymentRequest request) {
        Order order = new Order();
        log.info("process build to entity and save request -> description : {} {}", request.getOrderDescription(), request.getPaymentAmount());
        order.setDescription(request.getOrderDescription());
        Order save = orderRepository.save(order);
        log.debug("success save to entity request -> description : {}", request.getOrderDescription());
        log.error("this is error on process save -> description : {} ", request.getOrderDescription() );
        return save.getDescription();
    }
}
