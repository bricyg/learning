package site.bitinit.salary.common.dataobject;

import java.util.Date;
import lombok.Data;

/**
 * @author john
 * @date 2021/10/30
 */
@Data
public abstract class BaseDO {

  private Long id;
  private Date createTime;
  private Date updateTime;

  protected BaseDO() {
    Date nowDate = new Date();
    this.createTime = nowDate;
    this.updateTime = nowDate;
  }
}
