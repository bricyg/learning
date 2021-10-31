package site.bitinit.salary.domain.employee.classification;

import lombok.Data;
import lombok.EqualsAndHashCode;
import site.bitinit.salary.domain.employee.PaymentClassification;

/**
 * @author john
 * @date 2021/10/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SalariedClassification extends PaymentClassification {

  private Double salary;

  public SalariedClassification(Double salary) {
    this.salary = salary;
  }
}
