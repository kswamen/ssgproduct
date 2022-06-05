package com.ssg.ssgproduct.util;

import com.ssg.ssgproduct.exception.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CustomResponse {
    public static ResponseEntity<Object> create(ResponseCode responseCode, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", responseCode.getMessage());
        map.put("status", responseCode.getStatus());
        map.put("code", responseCode.getCode());
        map.put("specificCode", responseCode.getSpecificCode());
        map.put("data", responseObj);

        return new ResponseEntity<>(map, responseCode.getStatus());
    }
}

