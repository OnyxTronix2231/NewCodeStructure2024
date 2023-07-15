package frc.robot.logging.benPOC;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class onyxLogAspect {

        @Before("@annotation(frc.robot.logging.benPOC.OnyxLog)")
        public void logFunctionName(JoinPoint joinPoint) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            String functionName = methodSignature.getName();
            System.out.println("Function Name: " + functionName);
        }
}
