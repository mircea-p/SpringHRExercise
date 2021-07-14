package home.sda.springhumanresoursces.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date creationDate;
    @OneToOne(mappedBy = "account") // teren account este numele field-ului din Employee.
    private Employee employee;


}
