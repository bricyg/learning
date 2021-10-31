package site.bitinit.salary.infrastructure.convertor.employee;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import site.bitinit.salary.common.utils.JsonUtils;
import site.bitinit.salary.domain.affiliation.AffiliationId;
import site.bitinit.salary.domain.employee.Employee;
import site.bitinit.salary.domain.employee.PaymentClassification;
import site.bitinit.salary.domain.employee.PaymentMethod;
import site.bitinit.salary.domain.employee.PaymentSchedule;
import site.bitinit.salary.domain.employee.classification.PaymentClassificationType;
import site.bitinit.salary.domain.employee.paymentmothd.PaymentMethodType;
import site.bitinit.salary.domain.employee.schedule.PaymentScheduleType;
import site.bitinit.salary.infrastructure.meta.employee.EmployeeDO;

import java.util.List;
import java.util.Objects;
import site.bitinit.salary.infrastructure.meta.employee.PaymentClassificationDO;
import site.bitinit.salary.infrastructure.meta.employee.PaymentMethodDO;

/**
 * @author john
 * @date 2021/10/24
 */
@Slf4j
public class EmployeeConvertor {

    public static EmployeeDO convertToEmployeeDO(Employee employee) {
        EmployeeDO employeeDO = new EmployeeDO();
        BeanUtils.copyProperties(employee, employeeDO);
        employeeDO.setAffiliations(JsonUtils.toJson(employee.getAffiliations()));

        PaymentMethodType paymentMethodType = PaymentMethodType.of(employee.getPaymentMethod().getClass());
        PaymentMethodDO paymentMethodDO = new PaymentMethodDO();
        paymentMethodDO.setPaymentMethodType(paymentMethodType.getCode());
        paymentMethodDO.setPaymentMethod(JsonUtils.toJson(employee.getPaymentClassification()));
        employeeDO.setPaymentClassification(JsonUtils.toJson(paymentMethodDO));

        PaymentClassificationType classificationType = PaymentClassificationType.of(employee.getPaymentClassification().getClass());
        PaymentClassificationDO paymentClassificationDO = new PaymentClassificationDO();
        paymentClassificationDO.setPaymentClassificationType(classificationType.getCode());
        paymentClassificationDO.setPaymentClassification(JsonUtils.toJson(employee.getPaymentMethod()));
        employeeDO.setPaymentMethod(JsonUtils.toJson(paymentClassificationDO));

        PaymentScheduleType paymentScheduleType = PaymentScheduleType.of(employee.getPaymentSchedule().getClass());
        employeeDO.setPaymentSchedule(paymentScheduleType.getCode());
        return employeeDO;
    }

    public static Employee convertToEmployee(EmployeeDO employeeDO) {
        if (Objects.isNull(employeeDO)) {
            return null;
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDO, employee);

        PaymentMethodDO paymentMethodDO = JsonUtils.readValue(employeeDO.getPaymentMethod(), PaymentMethodDO.class);
        PaymentMethodType paymentMethodType = PaymentMethodType.typeOf(paymentMethodDO.getPaymentMethodType());
        PaymentMethod pm = (PaymentMethod) JsonUtils.readValue(employeeDO.getPaymentMethod(), paymentMethodType.getClazz());
        employee.setPaymentMethod(pm);

        PaymentClassificationDO classificationDO = JsonUtils.readValue(employeeDO.getPaymentClassification(),
            PaymentClassificationDO.class);
        PaymentClassification pc = PaymentClassificationType.valueOf(classificationDO.getPaymentClassificationType(),
            classificationDO.getPaymentClassification());
        employee.setPaymentClassification(pc);

        employee.setPaymentSchedule(PaymentScheduleType.valueOf(employeeDO.getPaymentSchedule(), "{}"));

        employee.setAffiliations(
                JsonUtils.readValue(employeeDO.getAffiliations(), new TypeReference<List<AffiliationId>>() {}));
        return employee;
    }
}
