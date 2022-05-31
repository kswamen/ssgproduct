package com.ssg.ssgproduct.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex) {
        log.error("RuntimeException", ex);
        return "RuntimeException test";
    }

//    @ExceptionHandler(EmailDuplicateException.class)
//    public ResponseEntity<CustomResponse> handleEmailDuplicateException(EmailDuplicateException ex){
//        log.error("handleEmailDuplicateException", ex);
//        CustomResponse response = new CustomResponse(ex.getErrorCode());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
//    }
}