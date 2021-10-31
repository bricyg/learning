package site.bitinit.salary.infrastructure.repository;

import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import org.springframework.stereotype.Component;
import site.bitinit.salary.common.utils.RetryUtils;
import site.bitinit.salary.domain.affiliation.AffiliationId;
import site.bitinit.salary.domain.employee.Employee;
import site.bitinit.salary.domain.employee.EmployeeRepository;
import site.bitinit.salary.infrastructure.convertor.employee.EmployeeConvertor;
import site.bitinit.salary.infrastructure.mapper.EmployeeMapper;
import site.bitinit.salary.infrastructure.meta.employee.EmployeeDO;

import javax.annotation.Resource;

/**
 * @author john
 * @date 2021/10/24
 */
@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public void save(Employee employee) {
        EmployeeDO employeeDO = EmployeeConvertor.convertToEmployeeDO(employee);
        employeeMapper.save(employeeDO);
    }

    @Override
    public Employee employeeOfId(Long id) {
        EmployeeDO employeeDO = employeeMapper.getById(id);
        return EmployeeConvertor.convertToEmployee(employeeDO);
    }

    @Override
    public boolean updateAffiliations(Employee employee) {
        EmployeeDO employeeDO = EmployeeConvertor.convertToEmployeeDO(employee);

        return RetryUtils.retry(5, 100, () ->
            employeeMapper.updateAffiliations(
                employeeDO.getId(),
                employeeDO.getAffiliations(),
                employeeDO.getVersion(),
                employeeDO.getVersion() + 1)
        );
    }
}
