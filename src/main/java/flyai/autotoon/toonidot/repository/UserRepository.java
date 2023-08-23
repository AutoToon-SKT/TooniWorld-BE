package flyai.autotoon.toonidot.repository;

import flyai.autotoon.toonidot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
