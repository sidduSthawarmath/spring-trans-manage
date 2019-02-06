package com.siddu.annotation.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * @Configuration :
 * Used to indicate that a class declares one or more @Bean methods. These
 * classes are processed by the Spring container to generate bean
 * definitions and service requests for those beans at runtime.
 */

@Configuration
@PropertySource("classpath:application.properties")
/*
 * @ComponentScan : Configures component scanning directives for use
 * with @Configuration classes. Here we can specify the base packages to scan
 * for spring components.
 */
@ComponentScan("com.siddu")
public class ConfigurartionAnnotation {

	/*
	 * @Bean: Indicates that a method produces a bean to be managed by the
	 * Spring container. This is one of the most used and important spring
	 * annotation. @Bean annotation also can be used with parameters like name,
	 * initMethod and destroyMethod.
	 */
	/* name – allows you give name for bean */
	/*
	 * initMethod – allows you to choose method which will be invoked on context
	 * register
	 */
	/*
	 * destroyMethod – allows you to choose method which will be invoked on
	 * context shutdown
	 */

	@Bean(name = "dateUtil", initMethod = "initMethodTest", destroyMethod = "destoryMethodTest")
	public DateUtil dateUtility() {
		return new DateUtil();
	}

	@Bean
	public CustomMessages custMsg() {
		return new CustomMessages();
	}

	/*@Autowired
	private ApplicationContext context;

	@Bean
	public MyService MyServiceAlias(@Value("${beanName}") String qualifier) {
		return (MyService) context.getBean(qualifier);
	}*/

}
