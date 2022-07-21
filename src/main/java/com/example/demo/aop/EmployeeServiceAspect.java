package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class EmployeeServiceAspect {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceAspect.class);
	
	@Before("execution(* com.example.demo.DemoApplication.*(..)))")  
	public void beforeAspect(JoinPoint joinPoint) {
		logger.debug("Enterting the method with name :: " + joinPoint.getSignature().getName());
		logger.debug("Kind :: " + joinPoint.getKind());
	}
	
	@Around("execution(* com.example.demo..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 	{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
          
        final StopWatch stopWatch = new StopWatch();
          
        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
  
        //Log method execution time
        logger.info("Execution time of " + className + "." + methodName +  " "  + ":: " + stopWatch.getTotalTimeMillis() + " ms");
  
        return result;
    }

}
