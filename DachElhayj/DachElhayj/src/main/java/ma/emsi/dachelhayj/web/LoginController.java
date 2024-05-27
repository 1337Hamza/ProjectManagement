package ma.emsi.dachelhayj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login.html template
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied"; // Return the access-denied.html template
    }
}
