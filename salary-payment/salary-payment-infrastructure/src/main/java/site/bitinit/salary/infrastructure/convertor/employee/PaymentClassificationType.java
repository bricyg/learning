package site.bitinit.salary.infrastructure.convertor.employee;

/**
 * @author john
 * @date 2021/10/24
 */
public enum PaymentClassificationType {
    salariedPayment("salaried", "带薪员工", null),
    hourlyPayment("hourly", "钟点工", null),
    commissionedPayment("commissioned", "销售员工", null)
    ;
    private final String code;
    private final String description;
    private final Class<?> clazz;

    PaymentClassificationType(String code, String description, Class<?> clazz) {
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

    public static PaymentClassificationType typeOf(String code) {
        PaymentClassificationType[] types = PaymentClassificationType.values();
        for (PaymentClassificationType type: types) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static PaymentClassificationType classOf(Class<?> clazz) {
        PaymentClassificationType[] types = PaymentClassificationType.values();
        for (PaymentClassificationType type: types) {
            if (type.getClazz().equals(clazz)) {
                return type;
            }
        }
        return null;
    }
}
