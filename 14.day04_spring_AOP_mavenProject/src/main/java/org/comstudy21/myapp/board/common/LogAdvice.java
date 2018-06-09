package org.comstudy21.myapp.board.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect  // Aspect = Pointcut + annotation
public class LogAdvice {
	
	@Pointcut("execution(* org.comstudy21.myapp.board..*Impl.*(..))")
	public void allPointcut(){}
	
	@Before("allPointcut()")
	public void beforePrintLog(JoinPoint joinPoint){
		System.out.println("[공통] 비즈니스 로직 수행 전~~~" + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("allPointcut()")
	public void afterPrintLog(JoinPoint joinPoint){
		System.out.println("[공통] 비즈니스 로직 수행 후~~~" + joinPoint.getSignature().getName());
	}
}
