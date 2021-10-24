package site.bitinit.salary.infrastructure.convertor.employee;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.BeanUtils;
import site.bitinit.salary.common.utils.JsonUtils;
import site.bitinit.salary.domain.affiliation.AffiliationId;
import site.bitinit.salary.domain.employee.Employee;
import site.bitinit.salary.domain.employee.classification.PaymentClassification;
import site.bitinit.salary.domain.employee.paymentmothd.PaymentMethod;
import site.bitinit.salary.infrastructure.meta.EmployeeDO;

import java.util.List;
import java.util.Objects;

/**
 * @author john
 * @date 2021/10/24
 */
public class EmployeeConvertor {

    public static EmployeeDO convertToEmployeeDO(Employee employee) {
        EmployeeDO employeeDO = new EmployeeDO();
        BeanUtils.copyProperties(employee, employeeDO);
        employeeDO.setAffiliations(JsonUtils.toJson(employee.getAffiliations()));

        PaymentMethodType paymentMethodType = PaymentMethodType.classOf(employee.getPaymentMethod().getClass());
        employeeDO.setPaymentMethodType(Objects.requireNonNull(paymentMethodType).getCode());
        employeeDO.setPaymentClassification(JsonUtils.toJson(employee.getPaymentClassification()));

        PaymentClassificationType classificationType = PaymentClassificationType.classOf(employee.getPaymentClassification().getClass());
        employeeDO.setPaymentClassificationType(Objects.requireNonNull(classificationType).getCode());
        employeeDO.setPaymentMethod(JsonUtils.toJson(employee.getPaymentMethod()));
        return employeeDO;
    }

    public static Employee convertToEmployee(EmployeeDO employeeDO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDO, employee);

        PaymentMethodType paymentMethodType = PaymentMethodType.typeOf(employeeDO.getPaymentMethodType());
        PaymentMethod pm = (PaymentMethod) JsonUtils.readValue(employeeDO.getPaymentMethod(),
                Objects.requireNonNull(paymentMethodType).getClazz());
        employee.setPaymentMethod(pm);

        PaymentClassificationType classificationType = PaymentClassificationType.typeOf(employeeDO.getPaymentClassificationType());
        PaymentClassification pc = (PaymentClassification) JsonUtils.readValue(employeeDO.getPaymentClassification(),
                Objects.requireNonNull(classificationType).getClazz());
        employee.setPaymentClassification(pc);

        employee.setAffiliations(
                JsonUtils.readValue(employeeDO.getAffiliations(), new TypeReference<List<AffiliationId>>() {}));
        return employee;
    }
}
