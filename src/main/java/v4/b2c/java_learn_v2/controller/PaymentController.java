package v4.b2c.java_learn_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import v4.b2c.java_learn_v2.dto.OrderAndPaymentRequest;
import v4.b2c.java_learn_v2.service.OrderService;
import v4.b2c.java_learn_v2.service.impl.ProcessServiceImpl;

@RestController
@RequestMapping("/order")
public class PaymentController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProcessServiceImpl processServiceImpl;

    @PostMapping
    private String processTransactionOrder(@RequestBody OrderAndPaymentRequest request) {
        return orderService.processTransactionOrder(request);
    }

    @PostMapping("/create-order")
    private String createOrder(@RequestBody OrderAndPaymentRequest request) {
        return processServiceImpl.createOrder(request);
    }

    @PutMapping("/{id}")
    private String updateProcessOrder(@PathVariable("id") Long id,
                                      @RequestBody OrderAndPaymentRequest request) {
        try {
            return orderService.updateProcessOrder(id, request);

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
