package main.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* main.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();

        System.out.println("Start of " + name);

        long startMethodTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endMethodTime = System.currentTimeMillis();

        System.out.println("End of " + name + " - time execution: " + (endMethodTime - startMethodTime));

        return proceed;
    }
}
