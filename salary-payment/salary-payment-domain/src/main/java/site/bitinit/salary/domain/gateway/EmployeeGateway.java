package site.bitinit.salary.domain.gateway;

import site.bitinit.salary.domain.employee.Employee;

/**
 * @author john
 * @date 2021/10/24
 */
public interface EmployeeGateway {

    void create(Employee employee);

    Employee getById(Long employeeId);
}
