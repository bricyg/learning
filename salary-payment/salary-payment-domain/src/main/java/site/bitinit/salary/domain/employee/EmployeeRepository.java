package site.bitinit.salary.domain.employee;

import java.util.List;
import site.bitinit.salary.domain.affiliation.AffiliationId;
import site.bitinit.salary.domain.employee.Employee;

/**
 * @author john
 * @date 2021/10/24
 */
public interface EmployeeRepository {

    void save(Employee employee);

    Employee employeeOfId(Long id);

    boolean updateAffiliations(Employee employee);
}
