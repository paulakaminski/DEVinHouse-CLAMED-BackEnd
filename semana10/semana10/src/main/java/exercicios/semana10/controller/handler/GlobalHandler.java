package exercicios.semana10.controller.handler;

import exercicios.semana10.exception.BadRequestException;
import exercicios.semana10.exception.NotFoundException;
import exercicios.semana10.exception.ServerSideException;
import exercicios.semana10.padroes.DefaultErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity tratarNotFoundException(Exception e) {
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity tratarBadRequestException(Exception e) {
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(ServerSideException.class)
    public ResponseEntity tratarServerSideException(Exception e) {
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarMethodArgumentNotValidException(Exception e) {
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}
