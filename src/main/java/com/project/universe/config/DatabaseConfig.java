package com.project.universe.config;

import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/** Configuration class for reading secrets and connecting to database. */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "universe.backing-services.database")
public class DatabaseConfig {

	private String url;

	private String driverClassName;

	private String username;

	private String password;

	@Bean
	public DataSource dataSource() throws IOException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	public String getUrl() {
		return url;
	}

	public DatabaseConfig setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public DatabaseConfig setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public DatabaseConfig setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public DatabaseConfig setPassword(String password) {
		this.password = password;
		return this;
	}
}
