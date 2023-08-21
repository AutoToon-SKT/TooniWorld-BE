package flyai.autotoon.toonidot.repository;

import flyai.autotoon.toonidot.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}