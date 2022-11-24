package com.study;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@StepScope
// Tasklet도 인터페이스로 스프링배치 안에 존재한다 
public class HelloWorldTasklet implements Tasklet {

	@Override
	// execute 오버라이드하면 무조건 들어온다, 실행
	public RepeatStatus execute(StepContribution contribution
					, ChunkContext chunkContext) throws Exception {
		System.out.println("Hello world");
		// 반복상태
		return RepeatStatus.FINISHED;
	}

}
