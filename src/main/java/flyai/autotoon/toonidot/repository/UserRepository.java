package flyai.autotoon.toonidot.repository;

import flyai.autotoon.toonidot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
