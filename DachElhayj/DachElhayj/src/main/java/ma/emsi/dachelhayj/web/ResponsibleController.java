package ma.emsi.dachelhayj.web;

import jakarta.validation.Valid;
import ma.emsi.dachelhayj.dao.EmployeeRepository;
import ma.emsi.dachelhayj.dao.ProjectRepository;
import ma.emsi.dachelhayj.dao.ResponsibleRepository;
import ma.emsi.dachelhayj.dao.EmployeeRepository;
import ma.emsi.dachelhayj.dao.ProjectRepository;
import ma.emsi.dachelhayj.dao.ResponsibleRepository;
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

@Controller
public class ResponsibleController {
    @Autowired
    ResponsibleRepository responsibleRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;
    @GetMapping("/user/Responsibles")
    public String allEmp(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "6") int size,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Responsible> Responsibles = responsibleRepository.findByFullNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("ResponsiblesList",Responsibles.getContent());
        model.addAttribute("pages",new int[Responsibles.getTotalPages()]);
        model.addAttribute("CurrentPage",page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("size",size);
        return "AllResp";
    }

    @GetMapping("/admin/Respdelete")
    public String delete(int id, String keyword, int size, int page){

        responsibleRepository.deleteById(id);
        return "redirect:/user/Responsibles?page="+page+"&size"+size+"&keyword="+keyword;
    }


    @GetMapping("/admin/AddResp")
    public String AddResp(Model model){
        model.addAttribute("employees",employeeRepository.findAll());
        model.addAttribute("projects",projectRepository.findAll());
        model.addAttribute("responsible", new Responsible());
        return "AddResp";
    }

    @GetMapping("/admin/EditResp")
    public String EditResp(Model model, @RequestParam(name = "id") Integer id){
        model.addAttribute("employees",employeeRepository.findAll());
        model.addAttribute("projects",projectRepository.findAll());
        model.addAttribute("responsible", responsibleRepository.findById(id).get());
        return "EditResp";
    }

    @PostMapping("/admin/saveResp")
    public String saveResp(@Valid Responsible responsible, BindingResult bindingResult,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "6") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword){
        if(bindingResult.hasErrors()){
            return "AddResp";
        }
        responsibleRepository.save(responsible);
        return "redirect:/user/Responsibles?page="+page+"&size"+size+"&keyword="+keyword;
    }

}
