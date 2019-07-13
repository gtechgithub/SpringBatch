package springbatch.batch;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyTaskOne implements Tasklet {

	private static Logger logger =  Logger.getLogger(MyTaskOne.class);
	
	
	private PersonRepository repo;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

			logger.info("my task one starting .....");

			repo = ApplicationContextHolder.getContext().getBean(PersonRepository.class);
	    	List<Person> personList = repo.findAll();
			personList.forEach(person -> {
				System.out.println("person:" + person);
			});
			
			logger.info("my task one done and completed .....");

		return RepeatStatus.FINISHED;
	}

}
