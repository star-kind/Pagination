package cn.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * 项目启动器
 * 
 * @author gzh
 *
 */
@Configuration
@SpringBootApplication
@MapperScan(value = "cn.example.demo.mapper") // 扫描mapper/dao层接口包
public class DemoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		System.out.println("run- " + run.getEnvironment());
	}
	
}