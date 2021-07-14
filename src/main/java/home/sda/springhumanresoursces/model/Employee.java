package home.sda.springhumanresoursces.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private Integer salary;
    @OneToOne
    @JoinColumn(name = "account_id") // account_id este in baza de date.
    private Account account;

    @ManyToOne
    @JoinColumn(name = "departmentId") // asa apare in baza de date
    private Department department;

    @ManyToMany
    @JoinTable(name = "employees_projects",
    joinColumns = {@JoinColumn(name = "employeeId")},
    inverseJoinColumns = {@JoinColumn(name = "projectId")})
    private Set<Project> projectSet = new HashSet<>();

}
