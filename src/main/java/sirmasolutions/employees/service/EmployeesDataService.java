package sirmasolutions.employees.service;

import java.util.List;
import sirmasolutions.employees.model.EmployeesData;

public interface EmployeesDataService {
    void fill(List<String> values);

    List<EmployeesData> getAll();
}
