package wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @Description:1.MyBatis启动方式可以在mapper层不需要加注解，但是一定要在启动类的时候加上@MapperCan
 *              2.MyBatis在MyBatis接口加上@Mapper注入MyBatis容器，就不需要在启动类的时候加上@MapperCan
 * @author: wulongwei
 * @date:   2019年1月19日 上午9:10:22     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@SpringBootApplication
@MapperScan(basePackages= {"wechat.mapper"})
@EnableAutoConfiguration
public class app {

	public static void main(String[] args) {
		SpringApplication.run(app.class, args);
	}
}
