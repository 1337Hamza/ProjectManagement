package ma.emsi.dachelhayj.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
public class Responsible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotEmpty
    private String fullName;
    @NotNull
    private Integer PhoneNumber;
    @NotEmpty
    private String Email;

    //@OneToMany(mappedBy = "responsible")
    //private Collection<Project> projects;
}
