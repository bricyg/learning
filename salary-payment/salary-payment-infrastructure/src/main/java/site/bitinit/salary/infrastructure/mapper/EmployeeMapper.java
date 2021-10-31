package site.bitinit.salary.infrastructure.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import site.bitinit.salary.infrastructure.meta.employee.EmployeeDO;

/**
 * @author john
 * @date 2021/10/24
 */
@Mapper
public interface EmployeeMapper {

  /**
   * 保存
   *
   * @param employeeDO employeeDO
   */
  @Insert("INSERT INTO employee " +
      "(name, address, payment_classification, payment_method, affiliations) " +
      "VALUES" +
      "(#{name}, #{address}, #{paymentClassification}, #{paymentMethod}, #{affiliations})")
  void save(EmployeeDO employeeDO);

  /**
   * 根据 id 获取
   *
   * @param id 雇员 id
   * @return EmployeeDO
   */
  @Select("SELECT * FROM employee where id = #{id}")
  EmployeeDO getById(@Param("id") Long id);

  @Update("UPDATE employee SET affiliations = #{affiliations}, version = #{newVersion}" +
      "WHERE id = #{employId} and version = #{oldVersion}")
  boolean updateAffiliations(@Param("employId") Long employId,
      @Param("affiliations") String affiliations,
      @Param("oldVersion") int oldVersion,
      @Param("newVersion") int newVersion);
}
