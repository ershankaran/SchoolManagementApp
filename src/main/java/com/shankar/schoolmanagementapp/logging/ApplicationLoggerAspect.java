package com.shankar.schoolmanagementapp.logging;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.shankar.schoolmanagementapp.Controller..*)"+"|| within(com.shankar.schoolmanagementapp.dao..*)")
    public void definePackagePointCuts(){
        // empty method to name the location specified in pointcu
    }

    @After("definePackagePointCuts()")
    public void beforeLog(JoinPoint jp){
        log.debug("\n \n \n");
        log.debug("***********Before method Execution************* \n {}.{} () with arguments[s] = {} ",jp.getSignature().getDeclaringTypeName(),
                                     jp.getSignature().getName(),Arrays.toString(jp.getArgs())); // devices
        log.debug("------------------------------------------------------------\n");                            
        
    }
    
}
