package site.bitinit.salary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author john
 * @date 2021/10/23
 */
@SpringBootApplication
//@MapperScan(basePackages = "site.bitinit.salary.infrastructure.mapper")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
