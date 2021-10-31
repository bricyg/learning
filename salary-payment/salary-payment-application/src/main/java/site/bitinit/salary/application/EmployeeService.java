package site.bitinit.salary.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.bitinit.salary.application.command.AddSalariedEmployeeCommand;
import site.bitinit.salary.common.exception.SalaryPaymentException;
import site.bitinit.salary.domain.employee.Employee;
import site.bitinit.salary.domain.employee.EmployeeRepository;
import site.bitinit.salary.domain.employee.classification.SalariedClassification;
import site.bitinit.salary.domain.employee.paymentmothd.PaymentMethodType;
import site.bitinit.salary.domain.employee.schedule.PaymentScheduleType;

/**
 * @author wangjie29
 * @date 2021/10/25
 **/
@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public void addSalariedEmployee(AddSalariedEmployeeCommand cmd) {
    if (!PaymentMethodType.contains(cmd.getPaymentMethodType())) {
      throw new SalaryPaymentException("支付方法错误");
    }
    if (!PaymentScheduleType.contains(cmd.getPaymentScheduleType())) {
      throw new SalaryPaymentException("支付薪水时间错误");
    }

    Employee employee = new Employee();
    employee.setName(cmd.getName());
    employee.setAddress(cmd.getAddress());
    employee.setPaymentClassification(new SalariedClassification(cmd.getSalary()));
//    employee.setPaymentSchedule();

  }
}
