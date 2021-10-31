package site.bitinit.salary.common.utils;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;

/**
 * 重试工具
 * @author john
 * @date 2021/10/30
 */
@Slf4j
public class RetryUtils {

  /**
   * 重试工具
   * @param tryTime 重试次数
   * @param sleepInMillis 失败后睡眠时间
   * @param func 执行逻辑
   * @return 执行是否成功
   */
  public static boolean retry(int tryTime, long sleepInMillis, BooleanSupplier func) {
    Exception ex = null;
    for (; tryTime > 0; tryTime--) {
      try {
        if (func.getAsBoolean()) {
          return true;
        }
        Thread.sleep(sleepInMillis);
      } catch (Exception e) {
        ex = e;
      }
    }

    if (Objects.nonNull(ex)) {
      log.error("retry error", ex);
    }
    return false;
  }
}
