package com.study;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class BatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final HelloWorldTasklet helloWorldTasklet;
	
	@Bean
	public Job helloWorldJob(Step helloWorldStep) {
		return jobBuilderFactory.get("helloWorldJob")
				.flow(helloWorldStep)
				.end()
				.build();
	}
	
	@Bean
	public Step helloWorldStep() {
		return stepBuilderFactory.get("helloWorldStep")
				.tasklet(helloWorldTasklet)
				.build();
	}
		
}
