package site.bitinit.salary.domain.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import site.bitinit.salary.common.model.EntityWithVersion;
import site.bitinit.salary.domain.affiliation.AffiliationId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author john
 * @date 2021/10/24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends EntityWithVersion {

    private String name;

    private String address;

    private PaymentClassification paymentClassification;

    private PaymentMethod paymentMethod;

    private PaymentSchedule paymentSchedule;

    private List<AffiliationId> affiliations;

    public void addAffiliation(AffiliationId affiliationId) {
        if (Objects.isNull(this.affiliations)) {
            this.affiliations = new ArrayList<>();
        }
        this.affiliations.add(affiliationId);
    }
}
