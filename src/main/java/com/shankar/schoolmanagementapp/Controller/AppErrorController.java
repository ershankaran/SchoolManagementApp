package com.shankar.schoolmanagementapp.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "errorpages/error-404";
            }

            if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                return "errorpages/error-500";
            }

            if(statusCode == HttpStatus.FORBIDDEN.value()){
                return "errorpages/error-403";
            }

            if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()){
                return "errorpages/error-405";
            }
        }

        return "errorpages/errorpage";
    }
    
    public String getErrorPath(){
        return "/error";
    }
    
}
