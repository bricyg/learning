package site.bitinit.salary.domain.employee.classification;

import site.bitinit.salary.common.utils.JsonUtils;
import site.bitinit.salary.domain.employee.PaymentClassification;

/**
 * @author john
 * @date 2021/10/24
 */
public enum PaymentClassificationType {
    /**
     * 带薪员工
     */
    salariedPayment("salaried", "带薪员工", SalariedClassification.class),
    /**
     * 钟点工
     */
    hourlyPayment("hourly", "钟点工", HourlyClassification.class),
    /**
     * 销售员
     */
    commissionedPayment("commissioned", "销售员", null)
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

    public static PaymentClassificationType of(String code) {
        PaymentClassificationType[] types = PaymentClassificationType.values();
        for (PaymentClassificationType type: types) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("没有该 code:" + code);
    }

    public static PaymentClassificationType of(Class<?> clazz) {
        PaymentClassificationType[] types = PaymentClassificationType.values();
        for (PaymentClassificationType type: types) {
            if (type.getClazz().equals(clazz)) {
                return type;
            }
        }
        throw new IllegalArgumentException("没有该 class:" + clazz.getName());
    }

    public static PaymentClassification valueOf(String code, String json) {
        PaymentClassificationType type = of(code);
        return (PaymentClassification) JsonUtils.readValue(json, type.getClazz());
    }
}
