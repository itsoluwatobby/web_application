//package com.itsoluwatobby.spring.email.client.Error;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.time.LocalDateTime;
//
//@ControllerAdvice
//public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorMessage> mailExceptionHandler() {
//        ErrorMessage errorMessage = new ErrorMessage();
//        errorMessage.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
//        errorMessage.setMessage("");
//        errorMessage.setTime(LocalDateTime.now());
//
//        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
//    }
//}
