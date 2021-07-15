package home.sda.springhumanresoursces.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;

        @OneToMany(mappedBy = "department") // aici pun numele clasei din employee
        private List<Employee> employeeList;

        @Override
        public String toString() {
                return "Department{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
        }
}


