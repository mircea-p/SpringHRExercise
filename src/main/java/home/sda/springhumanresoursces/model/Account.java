package home.sda.springhumanresoursces.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date creationDate;
    @OneToOne(mappedBy = "account", cascade = CascadeType.MERGE  ) // teren account este numele field-ului din Employee.
    private Employee employee;


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                '}';
    }

    public Account(Date creationDate) {
        this.creationDate = creationDate;
    }
}
