package springbatch.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyTaskTwo implements Tasklet {

	private static Logger logger =  Logger.getLogger(MyTaskTwo.class);
	
	private PersonRepository repo;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

			logger.info("my task two starting .....");
			
			repo = ApplicationContextHolder.getContext().getBean(PersonRepository.class);
	    	Person person = repo.findOne(2);
			System.out.println("Single person Record:" + person);
			
			logger.info("my task two done and completed .....");

		return RepeatStatus.FINISHED;
	}

}
