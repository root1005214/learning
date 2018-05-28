package com.zhenghao.learning.bootstrap;

import com.zhenghao.learning.sharding.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jiangzhenghao
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.zhenghao.learning.sharding"})
public class BootStrap
{

  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(BootStrap.class, args);
    applicationContext.getBean(DemoService.class).demo();
  }
}
