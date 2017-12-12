package cn.morethink.exception;


import cn.morethink.util.Result;
import cn.morethink.util.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author 李文浩
 * @version 2017/2/15.
 */

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public Result handleErrorException(ErrorException e) {
        Result result = new Result();
        result.setStatus("0");
        result.setMessage(e.getError());
        return result;
    }


    @ExceptionHandler(NullPointerException.class)
    public Result handleNullPointerException(NullPointerException e) {
        e.printStackTrace();
        Result result = new Result();
        result.setStatus("0");
        result.setMessage("发生空指针异常.");
        return result;
    }

    @ExceptionHandler(NumberFormatException.class)
    public Result handleNumberFormatException(NumberFormatException e) {
        Result result = new Result();
        result.setStatus("0");
        result.setMessage("你传的不是数字吧");
        return result;

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        List<String> list = new ArrayList<String>();
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            list.add(s.getMessage());
        }
        Result result = new Result();
        result.setStatus("0");
        result.setMessage(list);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return ResultUtil.UNHANDED_RESULT;
    }

}

