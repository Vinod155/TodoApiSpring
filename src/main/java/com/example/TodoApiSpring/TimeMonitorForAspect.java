package com.example.TodoApiSpring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorForAspect {

    @Around("@annotation(TimeMonitor)") //advice
    public void logtime(ProceedingJoinPoint joinPoint)
    {
        long start=System.currentTimeMillis();

        //execute the join point
         try{
             joinPoint.proceed();
         }catch(Throwable e)
        {
            System.out.println("error occured");
        }

        long end=System.currentTimeMillis();
        long totaltime=end-start;
        System.out.println("Total time of execution of method is: "+totaltime+"ms");
    }
}
