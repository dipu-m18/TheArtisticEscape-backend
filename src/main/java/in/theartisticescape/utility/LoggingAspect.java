package in.theartisticescape.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import in.theartisticescape.TheArtisticEscapeApplication;

@Component
@Aspect
public class LoggingAspect {
	

	private static Logger logger = LogManager.getLogger(TheArtisticEscapeApplication.class);

	@AfterThrowing(pointcut="execution(* in.theartisticescape.repository.*Impl.*(..))", throwing="exception")
	public void logExcpetionFromRepository(Exception exception) {
		logger.error(exception.getMessage(), exception);
	}
	
	@AfterThrowing(pointcut="execution(* com.theartisticescape.service.*Impl.*(..))", throwing="exception")
	public void logExceptionFromService(Exception exception) {
		logger.error(exception.getMessage(), exception);
	}
}
