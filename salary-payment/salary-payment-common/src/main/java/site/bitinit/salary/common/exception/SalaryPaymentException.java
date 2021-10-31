package site.bitinit.salary.common.exception;

/**
 * @author john
 * @date 2021/10/31
 */
public class SalaryPaymentException extends RuntimeException{

  public SalaryPaymentException() {
  }

  public SalaryPaymentException(String message) {
    super(message);
  }

  public SalaryPaymentException(String message, Throwable cause) {
    super(message, cause);
  }

  public SalaryPaymentException(Throwable cause) {
    super(cause);
  }

  public SalaryPaymentException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
