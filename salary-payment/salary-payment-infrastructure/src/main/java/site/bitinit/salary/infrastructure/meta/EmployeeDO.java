package site.bitinit.salary.infrastructure.meta;

import lombok.Data;

/**
 * @author john
 * @date 2021/10/24
 */
@Data
public class EmployeeDO {

    private Long id;
    private String name;
    private String address;
    private String paymentClassificationType;
    private String paymentClassification;
    private String paymentMethodType;
    private String paymentMethod;
    private String affiliations;
}
