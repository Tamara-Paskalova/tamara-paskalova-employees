package sirmasolutions.employees.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import sirmasolutions.employees.dao.EmployeesPairDao;
import sirmasolutions.employees.model.EmployeesData;
import sirmasolutions.employees.model.EmployeesPair;
import sirmasolutions.employees.service.EmployeesDataService;
import sirmasolutions.employees.service.EmployeesPairService;

@Service
public class EmployeesPairServiceImpl implements EmployeesPairService {
    private final EmployeesPairDao pairDao;
    private final EmployeesDataService dataService;

    public EmployeesPairServiceImpl(EmployeesPairDao pairDao, EmployeesDataService dataService) {
        this.pairDao = pairDao;
        this.dataService = dataService;
    }

    @Override
    public void fill() {
        List<EmployeesData> data = dataService.getAll();
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                EmployeesData first = data.get(i);
                EmployeesData second = data.get(j);
                if (Objects.equals(first.getProjectId(), second.getProjectId())) {
                    Duration duration = getDuration(first, second);
                    EmployeesPair pair = pairDao.getByFirstEmployeeAndSecondEmployee(first.getEmployeeId(), second.getEmployeeId());
                    if (pair != null) {
                        Duration pairDuration = pair.getDuration().plus(duration);
                        pair.setDuration(pairDuration);
                    } else {
                        pair = new EmployeesPair();
                        pair.setFirstEmployee(first);
                        pair.setSecondEmployee(second);
                        pair.setDuration(duration);
                    }
                    pairDao.save(pair);
                }
            }
        }
    }

    @Override
    public List<EmployeesPair> getAll() {
        return StreamSupport.stream(pairDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    private Duration getDuration(EmployeesData first, EmployeesData second) {
        LocalDate start = first.getDateFrom().isAfter(second.getDateFrom())
                ? first.getDateFrom() : second.getDateFrom();
        LocalDate end = first.getDateTo().isBefore(second.getDateTo())
                ? first.getDateTo() : second.getDateTo();
        return Duration.between(start.atStartOfDay(), end.atStartOfDay());
    }
}
