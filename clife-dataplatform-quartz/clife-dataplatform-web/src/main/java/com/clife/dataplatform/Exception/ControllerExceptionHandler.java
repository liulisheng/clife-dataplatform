package com.clife.dataplatform.Exception;


import com.clife.dataplatform.commons.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Exception e) {
        Map<String,Object> map=new HashMap<>();
        map.put("url",request.getRequestURL().toString());
        map.put("msg",e.getMessage());
        return ResponseResult.fail(map);
    }
}
