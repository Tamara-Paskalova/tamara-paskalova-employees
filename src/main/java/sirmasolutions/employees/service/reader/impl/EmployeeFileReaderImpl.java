package sirmasolutions.employees.service.reader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import sirmasolutions.employees.service.reader.EmployeeFileReader;

@Service
public class EmployeeFileReaderImpl implements EmployeeFileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                dataList.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
        return dataList;
    }
}
