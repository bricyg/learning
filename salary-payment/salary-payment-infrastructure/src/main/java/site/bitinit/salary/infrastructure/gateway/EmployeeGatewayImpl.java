package site.bitinit.salary.infrastructure.gateway;

import org.springframework.stereotype.Component;
import site.bitinit.salary.domain.employee.Employee;
import site.bitinit.salary.domain.gateway.EmployeeGateway;
import site.bitinit.salary.infrastructure.convertor.employee.EmployeeConvertor;
import site.bitinit.salary.infrastructure.mapper.EmployeeMapper;
import site.bitinit.salary.infrastructure.meta.EmployeeDO;

import javax.annotation.Resource;

/**
 * @author john
 * @date 2021/10/24
 */
@Component
public class EmployeeGatewayImpl implements EmployeeGateway {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public void create(Employee employee) {
        EmployeeDO employeeDO = EmployeeConvertor.convertToEmployeeDO(employee);
        employeeMapper.save(employeeDO);
    }

    @Override
    public Employee getById(Long employeeId) {
        EmployeeDO employeeDO = employeeMapper.getById(employeeId);
        return EmployeeConvertor.convertToEmployee(employeeDO);
    }
}
