package site.bitinit.salary.common.model;

import lombok.Data;

/**
 * @author john
 * @date 2021/10/30
 */
@Data
public abstract class Entity{

  private Long id;

  protected Entity() {}

}
