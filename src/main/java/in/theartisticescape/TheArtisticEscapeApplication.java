package in.theartisticescape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheArtisticEscapeApplication {
//implements CommandLineRunner{
	
	private static Logger logger = LogManager.getLogger(TheArtisticEscapeApplication.class);
	//private static final Log LOGGER = LogFactory.getLog(TheArtisticEscapeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TheArtisticEscapeApplication.class, args);
		
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		try{
//			logger.info("Logger"); 
//			System.out.println("Dipannita");
//			logger.info("Logger"); 
//		}catch(Exception exception){
//			logger.error("exception");
//		}
//		
//	}

}
