package chapter07.controller;

import chapter07.exception.DuplicateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author NikoBelic
 * @create 10/01/2017 09:04
 */
@ControllerAdvice
public class AppWideExceptionHandler
{
    @ExceptionHandler(DuplicateException.class)
    public String duplicateSpittleHandler()
    {
        return "error/duplicate";
    }
}
