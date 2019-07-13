package springbatch.batch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class AppCommandRunner implements CommandLineRunner {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;

	@Override
	public void run(String... args) throws Exception {
		JobParameters jobParameters =  new JobParametersBuilder().
				addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
		
		jobLauncher.run(job, jobParameters);
	}
	
	

}
