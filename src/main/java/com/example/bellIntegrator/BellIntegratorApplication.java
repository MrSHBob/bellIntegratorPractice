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

	@Bean
	public TaskExecutor controllerPool() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() + 1);
		executor.setQueueCapacity(25);
		return executor;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
}
