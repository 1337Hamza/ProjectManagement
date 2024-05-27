package ma.emsi.dachelhayj.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotEmpty
    private String name;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date StartDate;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date EndDate;

    //@ManyToOne
    //private Responsible responsible;
    //@ManyToMany
    //private Collection<Employee> employees;
}
