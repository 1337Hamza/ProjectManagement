package ma.emsi.dachelhayj.services;

import ma.emsi.dachelhayj.entities.Employee;
import ma.emsi.dachelhayj.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository produitRepository) {
        this.employeeRepository = produitRepository;
    }
    public void addProduit(Employee produit){
        employeeRepository.save(produit);
    }
    public Employee getProduitId(Integer id){
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Error"));
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public void deleteProduit(Integer id) {
        employeeRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return employeeRepository.existsById(id);
    }
}
