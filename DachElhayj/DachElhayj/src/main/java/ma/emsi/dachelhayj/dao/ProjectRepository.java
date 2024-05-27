package ma.emsi.dachelhayj.dao;

import ma.emsi.dachelhayj.entities.Project;
import ma.emsi.dachelhayj.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Page<Project> findByNameContains(String keyword, Pageable pageable);
}
