package com.example.mobilego.exception;

import com.example.mobilego.util.response.Result;
import com.example.mobilego.util.response.ResultHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author： ygl
 * @date： 2018/3/23-14:06
 * @Description：
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void globalException(HttpServletRequest req, HttpServletResponse res, Exception e) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            sb.append("\n");
            sb.append("\t"+stackTraceElement.toString());

        }
        log.error(sb.toString());
        res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public void unauthorizedException(HttpServletRequest req, HttpServletResponse res, Exception e) throws IOException {
        log.error(e.getMessage());
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());
    }
}
