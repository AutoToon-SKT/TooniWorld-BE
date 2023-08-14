package flyai.autotoon.toonidot.repository;

import flyai.autotoon.toonidot.entity.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartoonRepository extends JpaRepository<Cartoon, Long> {
}
