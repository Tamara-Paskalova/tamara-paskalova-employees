package sirmasolutions.employees.service.writer.impl;

import org.springframework.stereotype.Service;
import sirmasolutions.employees.model.EmployeesPair;
import sirmasolutions.employees.service.writer.EmployeeWriter;

@Service
public class EmployeeWriterImpl implements EmployeeWriter {
    @Override
    public void write(EmployeesPair pair) {
        System.out.println("********************--------------------*********************");
        System.out.printf("These two employees with id %s and id %s have worked together"
                + " for %s days on different projects!\n", pair.getFirstEmployee().getEmployeeId(),
                pair.getSecondEmployee().getEmployeeId(), pair.getDuration().toDaysPart());
        System.out.println("********************--------------------*********************");
    }
}
