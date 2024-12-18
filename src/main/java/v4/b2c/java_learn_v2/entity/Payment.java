package v4.b2c.java_learn_v2.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payment", schema = "public")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
