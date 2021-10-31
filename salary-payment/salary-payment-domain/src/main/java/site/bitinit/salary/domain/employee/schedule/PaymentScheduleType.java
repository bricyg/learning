package site.bitinit.salary.domain.employee.schedule;

import site.bitinit.salary.common.utils.JsonUtils;
import site.bitinit.salary.domain.employee.PaymentClassification;
import site.bitinit.salary.domain.employee.PaymentSchedule;
import site.bitinit.salary.domain.employee.classification.PaymentClassificationType;

/**
 * @author john
 * @date 2021/10/31
 */
public enum PaymentScheduleType {
  weeklySchedule("weekly", "周支付", WeeklySchedule.class),
  biWeeklySchedule("biWeekly", "两周支付", BiWeeklySchedule.class),
  monthlySchedule("monthly", "月支付", MonthlySchedule.class)
  ;

  private final String code;
  private final String description;
  private final Class<?> clazz;

  PaymentScheduleType(String code, String description, Class<?> clazz) {
    this.code = code;
    this.description = description;
    this.clazz = clazz;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public Class<?> getClazz() {
    return clazz;
  }

  public static boolean contains(String code) {
    PaymentScheduleType[] types = PaymentScheduleType.values();
    for (PaymentScheduleType type: types) {
      if (type.code.equals(code)) {
        return true;
      }
    }
    return false;
  }

  public static PaymentScheduleType of(String code) {
    PaymentScheduleType[] types = PaymentScheduleType.values();
    for (PaymentScheduleType type: types) {
      if (type.code.equals(code)) {
        return type;
      }
    }
    throw new IllegalArgumentException("没有该 code:" + code);
  }

  public static PaymentScheduleType of(Class<?> clazz) {
    PaymentScheduleType[] types = PaymentScheduleType.values();
    for (PaymentScheduleType type: types) {
      if (type.getClazz().equals(clazz)) {
        return type;
      }
    }
    throw new IllegalArgumentException("没有该 class:" + clazz.getName());
  }

  public static PaymentSchedule valueOf(String code, String json) {
    PaymentScheduleType type = of(code);
    return (PaymentSchedule) JsonUtils.readValue(json, type.getClazz());
  }
}
