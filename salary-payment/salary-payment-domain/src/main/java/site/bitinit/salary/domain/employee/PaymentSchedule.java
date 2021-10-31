package site.bitinit.salary.domain.employee;

import java.util.Date;

/**
 * @author john
 * @date 2021/10/31
 */
public interface PaymentSchedule {

  boolean isPayDay(Date date);

}
