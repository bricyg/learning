package site.bitinit.salary.infrastructure.convertor.employee;

import site.bitinit.salary.domain.employee.paymentmothd.HoldMethod;

/**
 * @author john
 * @date 2021/10/24
 */
public enum PaymentMethodType {
    holdPayment("hold", "支票支付", null),
    directMethod("direct", "现金支付", null),
    mailMethod("mail", "邮件支付", HoldMethod.class)
    ;

    private final String code;
    private final String description;
    private final Class<?> clazz;

    PaymentMethodType(String code, String description, Class<?> clazz) {
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

    public static PaymentMethodType typeOf(String code) {
        PaymentMethodType[] types = PaymentMethodType.values();
        for (PaymentMethodType type: types) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static PaymentMethodType classOf(Class<?> clazz) {
        PaymentMethodType[] types = PaymentMethodType.values();
        for (PaymentMethodType type: types) {
            if (type.getClazz().equals(clazz)) {
                return type;
            }
        }
        return null;
    }
}
