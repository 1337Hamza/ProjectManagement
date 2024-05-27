package ma.emsi.dachelhayj.web;

import jakarta.validation.Valid;
import ma.emsi.dachelhayj.dao.EmployeeRepository;
import ma.emsi.dachelhayj.entities.Employee;
import ma.emsi.dachelhayj.dao.EmployeeRepository;
import ma.emsi.dachelhayj.entities.Employee;
import ma.emsi.dachelhayj.entities.Responsible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.BindException;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/user/Employees")
    public String allEmp(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "6") int size,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Employee> Employeepages = employeeRepository.findByFullNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("EmployeesList",Employeepages.getContent());
        model.addAttribute("pages",new int[Employeepages.getTotalPages()]);
        model.addAttribute("CurrentPage",page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("size",size);
        return "AllEmp";
    }

    @GetMapping("/admin/Empdelete")
    public String delete(int id, String keyword, int size, int page){

        employeeRepository.deleteById(id);
        return "redirect:/user/Employees?page="+page+"&size"+size+"&keyword="+keyword;
    }

    @GetMapping("/admin/AddEmp")
    public String AddEmp(Model model){
        model.addAttribute("employee", new Employee());
        return "AddEmp";
    }

    @GetMapping("/admin/EditEmp")
    public String EditEmp(Model model, @RequestParam(name = "id") Integer id){
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return "EditEmp";
    }


    @PostMapping("/admin/saveEmp")
    public String saveEmp(@Valid Employee employee, BindingResult bindingResult,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "6") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword){
        if(bindingResult.hasErrors()){
            return "AddEmp";
        }
        employeeRepository.save(employee);
        return "redirect:/user/Employees?page="+page+"&size"+size+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/user/Employees";
    }
}
