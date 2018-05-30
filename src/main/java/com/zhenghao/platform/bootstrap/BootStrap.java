package com.zhenghao.platform.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @author jiangzhenghao
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootStrap
{

  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(BootStrap.class, args);
  }
}
