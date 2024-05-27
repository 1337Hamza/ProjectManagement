package ma.emsi.dachelhayj.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotEmpty
    private String fullName;
    @NotNull
    private Integer PhoneNumber;
    @NotEmpty
    private String Email;

    //@ManyToMany(mappedBy = "employees")
    //private Collection<Project> projects;
}
