package v4.b2c.java_learn_v2.service;

import v4.b2c.java_learn_v2.dto.OrderAndPaymentRequest;

public interface OrderService {

    String processTransactionOrder(OrderAndPaymentRequest request);

    String updateProcessOrder(Long id, OrderAndPaymentRequest request);
}
