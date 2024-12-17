package v4.b2c.java_learn_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v4.b2c.java_learn_v2.dto.OrderAndPaymentRequest;
import v4.b2c.java_learn_v2.service.OrderService;

@RestController
@RequestMapping("/order")
public class PaymentController {

    @Autowired
    OrderService orderService;

    @PostMapping
    private String processOrder(@RequestBody OrderAndPaymentRequest request) {
        return orderService.processOrder(request);
    }
}
