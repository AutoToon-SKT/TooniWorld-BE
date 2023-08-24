package flyai.autotoon.toonidot.repository;

import flyai.autotoon.toonidot.entity.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartoonRepository extends JpaRepository<Cartoon, Long> {
    List<Cartoon> findByInfoUsersUserId(Long userId);
}
