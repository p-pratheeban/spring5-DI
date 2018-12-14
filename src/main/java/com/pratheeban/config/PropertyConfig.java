package com.pratheeban.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.pratheeban.beans.DataSource;
import com.pratheeban.beans.JmsBroker;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
@PropertySources({ @PropertySource("classpath:datasource.properties"), @PropertySource("classpath:jms.properties") })
public class PropertyConfig {

	@Autowired
	Environment env;

	@Value("${db.username}")
	String user;

	@Value("${db.password}")
	String password;

	@Value("${db.url}")
	String url;

	@Value("${jms.username}")
	String jmsUsername;

	@Value("${jms.password}")
	String jmsPassoword;

	@Value("${jms.url}")
	String jmsUrl;

	@Bean
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUser(user);
		dataSource.setUser(env.getProperty("USER_NAME"));
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		return dataSource;
	}

	@Bean
	public JmsBroker getJmsBroker() {
		JmsBroker jmsBroker = new JmsBroker();
		jmsBroker.setUsername(jmsUsername);
		jmsBroker.setPassword(jmsPassoword);
		jmsBroker.setUrl(jmsUrl);
		return jmsBroker;
	}

	
	/*	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}*/
	 

}

/*
 Properties hierarchy priority
 Application Profile
 Application Properties
 Application YML
 Properties File
 
*/