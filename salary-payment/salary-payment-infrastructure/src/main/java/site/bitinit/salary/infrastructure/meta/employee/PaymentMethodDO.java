package site.bitinit.salary.infrastructure.meta.employee;

import lombok.Data;

/**
 * @author wangjie29
 * @date 2021/10/25
 **/
@Data
public class PaymentMethodDO {

  private String paymentMethodType;

  private String paymentMethod;
}
