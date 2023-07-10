package gl.example.TicketManager.services;

import gl.example.TicketManager.data.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();

    void deleteEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    Employee patchEmployeeById(Employee employee, Long id);

    Employee getEmployeeById(Long id);

}
