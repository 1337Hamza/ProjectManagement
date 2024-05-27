package ma.emsi.dachelhayj.dao;

import jakarta.transaction.Transactional;
import ma.emsi.dachelhayj.entities.Employee;
import ma.emsi.dachelhayj.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findByFullNameContains(String keyword , Pageable pageable);
}
