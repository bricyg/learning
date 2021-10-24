package site.bitinit.salary.infrastructure.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import site.bitinit.salary.infrastructure.meta.EmployeeDO;

/**
 * @author john
 * @date 2021/10/24
 */
@Mapper
public interface EmployeeMapper {

    @Insert("INSERT INTO employee " +
                "(name, address, payment_classification_type, payment_classification, payment_method_type, payment_method, affiliations) " +
            "VALUES" +
                "(#{name}, #{address}, #{paymentClassificationType}, #{paymentClassification}, #{paymentMethodType}, #{paymentMethod}, #{affiliations})")
    void save(EmployeeDO employeeDO);

    @Select("SELECT FROM employ where id = #{id}")
    EmployeeDO getById(@Param("id") Long id);
}
