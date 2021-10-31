package site.bitinit.salary.domain.employee.paymentmothd;

/**
 * @author john
 * @date 2021/10/24
 */
public enum PaymentMethodType {
    /**
     * 支票支付
     */
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
        throw new IllegalArgumentException("没有该 code:" + code);
    }

    public static PaymentMethodType of(Class<?> clazz) {
        PaymentMethodType[] types = PaymentMethodType.values();
        for (PaymentMethodType type: types) {
            if (type.getClazz().equals(clazz)) {
                return type;
            }
        }
        throw new IllegalArgumentException("没有该 class:" + clazz.getName());
    }

    public static boolean contains(String code) {
        PaymentMethodType[] types = PaymentMethodType.values();
        for (PaymentMethodType type: types) {
            if (type.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
}
