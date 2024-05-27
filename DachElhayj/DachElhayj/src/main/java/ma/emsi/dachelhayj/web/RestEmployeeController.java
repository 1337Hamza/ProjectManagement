package ma.emsi.dachelhayj.web;
import ma.emsi.dachelhayj.entities.Employee;
import ma.emsi.dachelhayj.dao.EmployeeRepository;
import ma.emsi.dachelhayj.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestEmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employee/{employeeid}")
    public ResponseEntity<Employee> getEmployees (@PathVariable Integer employeeid){
        Employee produit = employeeService.getProduitId(employeeid);
        return new ResponseEntity<>(produit,HttpStatus.OK);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployeesAll (){
        return employeeService.getAll();

    }
    @PostMapping("/addemployee")
    public ResponseEntity<String> addEmployees (@RequestBody Employee employee){
        employeeService.addProduit(employee);
        return new ResponseEntity<>("Employee ajoutee",HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/{employeeid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeid) {
        if (!employeeService.existsById(employeeid)) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
        employeeService.deleteProduit(employeeid);
        return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
    }}
