package ma.emsi.dachelhayj;

import ma.emsi.dachelhayj.dao.ProjectRepository;
import ma.emsi.dachelhayj.dao.EmployeeRepository;
import ma.emsi.dachelhayj.dao.ProjectRepository;
import ma.emsi.dachelhayj.dao.ResponsibleRepository;
import ma.emsi.dachelhayj.entities.Employee;
import ma.emsi.dachelhayj.entities.Project;
import ma.emsi.dachelhayj.entities.Responsible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class DachElhayjApplication implements CommandLineRunner {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(DachElhayjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

