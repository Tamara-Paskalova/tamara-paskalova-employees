package sirmasolutions.employees.service.impl;

import java.util.Comparator;
import org.springframework.stereotype.Service;
import sirmasolutions.employees.model.EmployeesPair;
import sirmasolutions.employees.service.EmployeesPairService;
import sirmasolutions.employees.service.PairSearcher;

@Service
public class PairSearcherImpl implements PairSearcher {
    private final EmployeesPairService service;

    public PairSearcherImpl(EmployeesPairService service) {
        this.service = service;
    }

    @Override
    public EmployeesPair findPair() {
        return service.getAll()
                .stream()
                .max(Comparator.comparing(EmployeesPair::getDuration)).get();
    }
}
