package org.jt.studentManagementSystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.StringJoiner;

@RestControllerAdvice

public class ErrorHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ProblemDetail handell(HttpRequestMethodNotSupportedException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), e.getMessage());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ProblemDetail handell(NoResourceFoundException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handell(MethodArgumentNotValidException e) {
        var details = new StringJoiner(", ");
        e.getAllErrors().forEach(error -> {
            var field = ((FieldError) error).getField();
            var message = error.getDefaultMessage();
//            details.add(message);
            details.add(field + " : " + message);//it is not a good parctice.
        });
        var problemDetail = ProblemDetail.forStatus(422);
        problemDetail.setTitle("INVALID____DATA");
        problemDetail.setDetail(details.toString());

        return problemDetail;
//        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(417), e.getMessage());
    }


}
