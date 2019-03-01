package com.my.spd.conf.exception;

import com.my.spd.message.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YangYuFan on 2019/2/23.
 */
@ControllerAdvice
public class ErrorHandle {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);


    @ResponseBody
    @ExceptionHandler(value ={Exception.class})
    public MessageModel errorHandle(HttpServletRequest request, Exception e){
        logger.error("出现了异常————————————————————————————————————————————————————————————————————————");
        logger.error("来源于:"+request.getRequestURL());
        logger.error(e.getMessage());
        return MessageModel.fail(e.getMessage());
    }
}
