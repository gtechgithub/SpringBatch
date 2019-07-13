package springbatch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	JobBuilderFactory jobFactory;
	
	@Autowired
	StepBuilderFactory stepsFactory;
	
	@Bean(name = "stepOne")
	public Step stepOne() {
		return stepsFactory.get("stepOne").tasklet(new MyTaskOne()).build();
	}
	
	@Bean(name = "stepTwo")
	public Step stepTwo() {
		return stepsFactory.get("stepTwo").tasklet(new MyTaskTwo()).build();
	}
	
	@Bean
	public  Job getJob() {
		return jobFactory.get("myjob").incrementer(new RunIdIncrementer()).start(stepOne()).next(stepTwo()).build();
	}
}
