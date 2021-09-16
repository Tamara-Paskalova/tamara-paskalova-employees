package sirmasolutions.employees.model;

import java.time.Duration;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class EmployeesPair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private EmployeesData firstEmployee;
    @ManyToOne
    private EmployeesData secondEmployee;
    private Duration duration;
}
