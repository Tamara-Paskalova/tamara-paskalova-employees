package sirmasolutions.employees.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sirmasolutions.employees.model.EmployeesPair;

public interface EmployeesPairDao extends CrudRepository<EmployeesPair, Long> {
    @Query("select e from EmployeesPair e where e.firstEmployee.employeeId=:first "
            + "and e.secondEmployee.employeeId=:second or e.firstEmployee.employeeId=:second "
            + "and e.secondEmployee.employeeId=:first")
    EmployeesPair getByFirstEmployeeAndSecondEmployee(Long first, Long second);
}
