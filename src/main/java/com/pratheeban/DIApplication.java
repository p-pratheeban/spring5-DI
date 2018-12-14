package com.pratheeban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.pratheeban.beans.DataSource;
import com.pratheeban.beans.JmsBroker;
import com.pratheeban.controllers.ConstructorInjectedController;
import com.pratheeban.controllers.MyController;
import com.pratheeban.controllers.PropertyInjectedController;
import com.pratheeban.controllers.SetterInjectedController;

@SpringBootApplication
@ComponentScan(basePackages = { "com.pratheeban" })
public class DIApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DIApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getUser());

		JmsBroker jmsBroker = ctx.getBean(JmsBroker.class);
		System.out.println(jmsBroker.getUsername());

	}
}
