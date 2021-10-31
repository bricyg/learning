package site.bitinit.salary.infrastructure.meta.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import site.bitinit.salary.common.dataobject.BaseDOWithVersion;

/**
 * @author john
 * @date 2021/10/24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDO extends BaseDOWithVersion {

    private String name;
    private String address;
    private String paymentClassification;
    private String paymentMethod;
    private String paymentSchedule;
    private String affiliations;
}
