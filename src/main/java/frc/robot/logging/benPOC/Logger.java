package frc.robot.logging.benPOC;

import java.lang.reflect.*;

public class Logger {
    public static void logMethodName(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(OnyxLog.class)) {
                System.out.println("Method name: " + method.getName());
            }
        }
    }
}