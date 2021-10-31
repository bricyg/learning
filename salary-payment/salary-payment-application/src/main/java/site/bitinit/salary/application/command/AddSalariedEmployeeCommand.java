package site.bitinit.salary.application.command;

import lombok.Data;
import site.bitinit.salary.domain.employee.paymentmothd.PaymentMethodType;
import site.bitinit.salary.domain.employee.schedule.PaymentScheduleType;

/**
 * @author john
 * @date 2021/10/31
 */
@Data
public class AddSalariedEmployeeCommand {

  private String name;
  private String address;
  private Double salary;
  /**
   * {@link PaymentScheduleType}'s code
   */
  private String paymentScheduleType;
  /**
   * {@link PaymentMethodType}'s code
   */
  private String paymentMethodType;

  private String paymentMethod;
}
