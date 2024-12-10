package v4.b2c.java_learn_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v4.b2c.java_learn_v2.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    // Anda bisa menambahkan custom query methods jika perlu
    UserEntity findByEmail(String email);
}
