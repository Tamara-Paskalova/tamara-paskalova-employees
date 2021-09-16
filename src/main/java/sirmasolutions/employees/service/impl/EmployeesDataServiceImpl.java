package sirmasolutions.employees.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import sirmasolutions.employees.dao.EmployeeDataDao;
import sirmasolutions.employees.model.EmployeesData;
import sirmasolutions.employees.service.EmployeesDataService;
import sirmasolutions.employees.util.ModelUtil;

@Service
public class EmployeesDataServiceImpl implements EmployeesDataService {
    private final EmployeeDataDao dao;

    public EmployeesDataServiceImpl(EmployeeDataDao dao) {
        this.dao = dao;
    }

    @Override
    public void fill(List<String> values) {
        values.stream()
                .map(ModelUtil::convertToModel)
                .forEach(dao::save);
    }

    @Override
    public List<EmployeesData> getAll() {
        return StreamSupport.stream(dao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
