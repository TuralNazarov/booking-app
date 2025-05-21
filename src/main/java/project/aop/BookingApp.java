package project.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class BookingApp {

    @Before("execution(* project.service.*(..))")
    public void LogBefore(JoinPoint joinPoint) {
        log.info("method starting: " + joinPoint.getSignature().getName());
    }

    @After("execution(* project.service.*(..))")
    public void LogAfter(JoinPoint joinPoint) {
        log.info("method ending: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* project.service.BookingService(..))",returning = "result")
    public void LogBookingReturning(JoinPoint joinPoint,Object result) {
        log.info("Booking created: " + joinPoint.getSignature().getName(),result);
    }

    @AfterReturning(value = "execution(* project.service.FlightService(..))",returning = "result")
    public void LogFlightReturning(JoinPoint joinPoint,Object result) {
        log.info("Flight created: " + joinPoint.getSignature().getName(),result);
    }

}
