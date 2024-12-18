package v4.b2c.java_learn_v2.service.impl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import v4.b2c.java_learn_v2.dto.OrderAndPaymentRequest;
import v4.b2c.java_learn_v2.entity.Order;
import v4.b2c.java_learn_v2.repository.OrderRepository;
import v4.b2c.java_learn_v2.repository.PaymentRepository;
import v4.b2c.java_learn_v2.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProcessServiceImpl processServiceImpl;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String processTransactionOrder(OrderAndPaymentRequest request) {
        processServiceImpl.validateAndSaveOrder(request);
        processServiceImpl.validateAndSavePayment(request);

        return "SUCCESS Create transaction, description: " + request.getOrderDescription() +
                ", paymentAmount : " + request.getPaymentAmount();
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @SneakyThrows
    public String updateProcessOrder(Long id, OrderAndPaymentRequest request) {

        try {
            Order order = orderRepository.findById(id).orElseThrow();
            order.setDescription(request.getOrderDescription());
            orderRepository.save(order);
            return "success";
        } catch (CannotAcquireLockException e) {
            return e.getMessage();
        } catch (DataAccessException e) {
            return e.getMessage();
        }

    }
}
