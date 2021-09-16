package sirmasolutions.employees.service.reader;

import java.util.List;

public interface EmployeeFileReader {
    List<String> readFromFile(String fileName);
}
