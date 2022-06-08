package com.ssg.ssgproduct.exception;

import com.ssg.ssgproduct.exception.exceptioncase.*;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        log.error("CustomerNotFoundException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

    @ExceptionHandler(ExitedCustomerException.class)
    public ResponseEntity<Object> handleExitedCustomerException(ExitedCustomerException ex) {
        log.error("ExitedCustomerException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
        log.error("ProductNotFoundException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

    @ExceptionHandler(PromotionNotFoundException.class)
    public ResponseEntity<Object> handlePromotionNotFoundException(PromotionNotFoundException ex) {
        log.error("PromotionNotFoundException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

    @ExceptionHandler(NoAvailPromotionException.class)
    public ResponseEntity<Object> handleNoAvailPromotionException(NoAvailPromotionException ex) {
        log.error("NoAvailPromotionException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

    @ExceptionHandler(NoAvailEnumValueException.class)
    public ResponseEntity<Object> handleNoAvailEnumValueException(NoAvailEnumValueException ex) {
        log.error("NoAvailEnumValueException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<Object> handleInvalidDateTimeFormatException(InvalidDateFormatException ex) {
        log.error("InvalidDateTimeFormatException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

    @ExceptionHandler(StartDateAfterEndDateException.class)
    public ResponseEntity<Object> handleStartDateAfterEndDateException(StartDateAfterEndDateException ex) {
        log.error("StartDateAfterEndDateException", ex);
        ResponseCode code = ex.getResponseCode();
        return CustomResponse.create(code, null);
    }

//    @ExceptionHandler(DateTimeParseException.class)
//    public ResponseEntity<Object> handleDateTimeParseException(DateTimeParseException ex) {
//        log.error("NoAvailPromotionException", ex);
//        ResponseCode code = ex.getResponseCode();
//        return CustomResponse.create(code, null);
//    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        log.error("RuntimeException", ex);
        return CustomResponse.create(ResponseCode.INTERNAL_SERVER_ERROR, null);
    }

}