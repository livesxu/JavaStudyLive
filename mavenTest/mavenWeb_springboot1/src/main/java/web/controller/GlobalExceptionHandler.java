package web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//切面
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody//响应体，自动返回json格式字符串
    public Map<String,Object> exceptionHandler() {

        Map<String,Object> map = new HashMap<>();

        map.put("errorCode","101");
        map.put("errorMsg","系统错误");

        return map;
    }
}
