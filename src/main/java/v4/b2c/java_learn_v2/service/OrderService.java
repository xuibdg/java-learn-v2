package v4.b2c.java_learn_v2.service;

import v4.b2c.java_learn_v2.dto.OrderAndPaymentRequest;

public interface OrderService {

    String processOrder(OrderAndPaymentRequest request);
}
