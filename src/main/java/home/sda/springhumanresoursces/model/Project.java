package home.sda.springhumanresoursces.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "name")
    private String name;
    @Transient // ii spune la hibernate sa nu se lege de el, sa-l ignore.
    private double budget;
    @Transient
    private String currency;
    @Enumerated(EnumType.STRING) // special pt enumuri, tipul: String sau Ordinal, se recomanda String.
    @Column(name = "type")
    private ProjectType projectType;

    @ManyToMany(mappedBy = "projectSet")
    private Set<Employee> employeeSet;


}
