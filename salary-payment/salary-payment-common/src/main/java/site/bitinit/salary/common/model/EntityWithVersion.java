package site.bitinit.salary.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author john
 * @date 2021/10/30
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class EntityWithVersion extends Entity {

  private Integer version;

  protected EntityWithVersion() {
    super();
    this.version = 0;
  }

}
