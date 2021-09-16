package sirmasolutions.employees.util;

import java.time.LocalDate;
import sirmasolutions.employees.model.EmployeesData;

public class ModelUtil {
    private static final int EMPLOYEE_ID_INDEX = 0;
    private static final int PROJECT_ID_INDEX = 1;
    private static final int DATE_FROM_INDEX = 2;
    private static final int DATE_TO_INDEX = 3;

    public static EmployeesData convertToModel(String value) {
        String[] dtoData = value.split(", ");
        EmployeesData data = new EmployeesData();
        data.setEmployeeId(Long.parseLong(dtoData[EMPLOYEE_ID_INDEX]));
        data.setProjectId(Long.parseLong(dtoData[PROJECT_ID_INDEX]));
        data.setDateFrom(DateUtil.convertToDate(dtoData[DATE_FROM_INDEX]));
        data.setDateTo(dtoData[DATE_TO_INDEX].equals("NULL") ? LocalDate.now() :
                DateUtil.convertToDate(dtoData[DATE_TO_INDEX]));
        return data;
    }
}
