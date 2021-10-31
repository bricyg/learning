package site.bitinit.salary.domain.employee.schedule;

import java.util.Date;
import site.bitinit.salary.domain.employee.PaymentSchedule;

/**
 * @author john
 * @date 2021/10/31
 */
public class BiWeeklySchedule implements PaymentSchedule {

  @Override
  public boolean isPayDay(Date date) {
    return false;
  }
}
