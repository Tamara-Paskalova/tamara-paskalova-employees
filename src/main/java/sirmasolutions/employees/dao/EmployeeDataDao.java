package sirmasolutions.employees.dao;

import org.springframework.data.repository.CrudRepository;
import sirmasolutions.employees.model.EmployeesData;

public interface EmployeeDataDao extends CrudRepository<EmployeesData, Long> {
}
