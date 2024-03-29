package cz.vibri.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cz.vibri.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// pointcut on methods in package
	@Before("cz.vibri.aopdemo.aspect.VibriAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAnyMethodInPackage(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on any method in package");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method signature: " + methodSig);
		
		//display the method arguments
		
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		//loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				//downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
	
}
