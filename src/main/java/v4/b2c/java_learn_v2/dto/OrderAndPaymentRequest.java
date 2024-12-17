package v4.b2c.java_learn_v2.dto;

import java.math.BigDecimal;

public class OrderAndPaymentRequest {
    private String orderDescription;
    private BigDecimal paymentAmount;

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
