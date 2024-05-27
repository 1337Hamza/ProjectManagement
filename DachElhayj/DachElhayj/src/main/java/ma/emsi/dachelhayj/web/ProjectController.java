package ma.emsi.dachelhayj.web;

import jakarta.validation.Valid;
import ma.emsi.dachelhayj.dao.ProjectRepository;
import ma.emsi.dachelhayj.dao.ProjectRepository;
import ma.emsi.dachelhayj.entities.Employee;
import ma.emsi.dachelhayj.entities.Project;
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
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @GetMapping("/user/Projects")
    public String allEmp(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "6") int size,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Project> projectPages = projectRepository.findByNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("ProjectsList",projectPages.getContent());
        model.addAttribute("pages",new int[projectPages.getTotalPages()]);
        model.addAttribute("CurrentPage",page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("size",size);
        return "Allproj";
    }

    @GetMapping("/admin/Projdelete")
    public String delete(int id, String keyword, int size, int page){

        projectRepository.deleteById(id);
        return "redirect:/admin/Projects?page="+page+"&size"+size+"&keyword="+keyword;
    }

    @GetMapping("/admin/AddProj")
    public String AddProj(Model model){
        model.addAttribute("project", new Project());
        return "AddProj";
    }

    @GetMapping("/admin/EditProj")
    public String EditProj(Model model, @RequestParam(name = "id") Integer id){
        model.addAttribute("project", projectRepository.findById(id).get());
        return "EditProj";
    }

    @PostMapping("/admin/saveProj")
    public String saveProj(@Valid Project project, BindingResult bindingResult,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "6") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword){
        if(bindingResult.hasErrors()){
            return "AddProj";
        }
        projectRepository.save(project);
        return "redirect:/user/Projects?page="+page+"&size"+size+"&keyword="+keyword;
    }
}
