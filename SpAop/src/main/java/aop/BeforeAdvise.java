package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class BeforeAdvise {
	
		@Before("execution(* aop.CustomerService.printName())")
		public void beforeName()  {
		        System.out.println("HijackBeforeMethod : Name is about to be printed...!");
		}
	}

