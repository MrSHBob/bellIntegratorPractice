package com.example.bellIntegrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
public class BellIntegratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellIntegratorApplication.class, args);
	}

}
