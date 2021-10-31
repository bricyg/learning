package site.bitinit.salary.common.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author john
 * @date 2021/10/30
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseDOWithVersion extends BaseDO{

  private Integer version;

  protected BaseDOWithVersion() {
    this.version = 0;
  }

}
