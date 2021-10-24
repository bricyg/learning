package site.bitinit.salary.domain.employee;

import lombok.Data;
import site.bitinit.salary.domain.affiliation.AffiliationId;
import site.bitinit.salary.domain.employee.classification.PaymentClassification;
import site.bitinit.salary.domain.employee.paymentmothd.PaymentMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author john
 * @date 2021/10/24
 */
@Data
public class Employee {

    private Long id;

    private String name;

    private String address;

    private PaymentClassification paymentClassification;

    private PaymentMethod paymentMethod;

    private List<AffiliationId> affiliations;

    public void addAffiliation(AffiliationId affiliationId) {
        if (Objects.isNull(this.affiliations)) {
            this.affiliations = new ArrayList<>();
        }
        this.affiliations.add(affiliationId);
    }
}
