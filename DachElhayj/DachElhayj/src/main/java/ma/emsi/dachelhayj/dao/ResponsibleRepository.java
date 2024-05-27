package ma.emsi.dachelhayj.dao;

import ma.emsi.dachelhayj.entities.Responsible;
import ma.emsi.dachelhayj.entities.Responsible;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.event.PaintEvent;

public interface ResponsibleRepository extends JpaRepository<Responsible,Integer> {
    Page<Responsible> findByFullNameContains(String keyword, Pageable pageable);
}
