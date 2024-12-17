package v4.b2c.java_learn_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v4.b2c.java_learn_v2.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
