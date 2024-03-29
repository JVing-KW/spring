package org.zerock.springex2.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.reflect.Array;
import java.util.Arrays;

@ControllerAdvice  // 컨트롤러에서 발생하는 예외에 맞게 처리할 수 있는 기능을 제공, @ControllerAdvice가 선언된 클래스(CommonExceptionAdvice) 역시 스프링의 빈으로 처리
@Log4j2
public class CommonExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException){
        log.error("-----------------------------------");
        log.error(numberFormatException.getMessage());
        return "NUMBER FORMAT EXCEPTION";
    }



    //범용적인 예외 처리
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception exception){
        log.error("-----------------------------------");
        log.error("에러 메시지 : " + exception.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" +exception.getMessage()+"</li>");

        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement->{
            buffer.append("<li>"+stackTraceElement+"</li>");
        });

        buffer.append("</ul>");
        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return  "custom404";
    }





}