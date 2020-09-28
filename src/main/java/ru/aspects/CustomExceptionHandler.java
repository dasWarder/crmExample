package ru.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.entity.CustomException;
import ru.util.exception.CustomerNotFound;

import java.time.LocalTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomException> getException(CustomerNotFound exc) {

        CustomException exceptionObj = new CustomException();

        exceptionObj.setType(HttpStatus.NOT_FOUND.value());
        exceptionObj.setMessage(exc.getMessage());
        exceptionObj.setDuration(LocalTime.now().getNano());

        return new ResponseEntity<>(exceptionObj, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomException> getException(Exception exc) {

        CustomException exceptionObj = new CustomException();

        exceptionObj.setType(HttpStatus.BAD_REQUEST.value());
        exceptionObj.setMessage("Something wrong with your request");
        exceptionObj.setDuration(LocalTime.now().getNano());

        return new ResponseEntity<>(exceptionObj, HttpStatus.BAD_REQUEST);
    }
}
