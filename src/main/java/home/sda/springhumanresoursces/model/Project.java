package home.sda.springhumanresoursces.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private double budget;
    @Transient
    private String currency;
    @Enumerated(EnumType.STRING) // special pt enumuri, tipul: String sau Ordinal, se recomanda String.
    @Column(name = "type")
    private ProjectType projectType;

    @ManyToMany(mappedBy = "projectSet")
    private Set<Employee> employeeSet;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", currency='" + currency + '\'' +
                ", projectType=" + projectType +
                '}';
    }
}
