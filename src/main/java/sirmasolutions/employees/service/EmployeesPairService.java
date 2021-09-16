package sirmasolutions.employees.service;

import java.util.List;
import sirmasolutions.employees.model.EmployeesPair;

public interface EmployeesPairService {
    void fill();

    List<EmployeesPair> getAll();
}
