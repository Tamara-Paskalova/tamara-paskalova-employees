package sirmasolutions.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sirmasolutions.employees.service.EmployeesDataService;
import sirmasolutions.employees.service.EmployeesPairService;
import sirmasolutions.employees.service.PairSearcher;
import sirmasolutions.employees.service.reader.EmployeeFileReader;
import sirmasolutions.employees.service.writer.EmployeeWriter;

@SpringBootApplication
public class EmployeesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeFileReader reader, PairSearcher searcher,
                                  EmployeesDataService dataService, EmployeesPairService pairService, EmployeeWriter writer) {
        return (args) -> {
            String file = "src/data.txt"; // replace this string with your file path
            dataService.fill(reader.readFromFile(file));
            pairService.fill();
            writer.write(searcher.findPair());
        };
    }
}
