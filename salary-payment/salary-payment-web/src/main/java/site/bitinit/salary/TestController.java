package site.bitinit.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.bitinit.salary.domain.employee.Employee;
import site.bitinit.salary.domain.employee.EmployeeRepository;

/**
 * @author john
 * @date 2021/10/30
 */
@RestController
public class TestController {

  @Autowired
  private final EmployeeRepository employeeRepository;

  public TestController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @GetMapping("/employee")
  public Employee e(Long employeeId) {
    return employeeRepository.employeeOfId(employeeId);
  }
}
