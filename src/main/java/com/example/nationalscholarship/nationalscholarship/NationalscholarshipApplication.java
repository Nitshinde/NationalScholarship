package com.example.nationalscholarship.nationalscholarship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.nationalscholarship.nationalscholarship.model.FileStorageProperties;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class NationalscholarshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(NationalscholarshipApplication.class, args);
	}

}
