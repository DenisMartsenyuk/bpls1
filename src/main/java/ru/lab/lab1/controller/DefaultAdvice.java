package ru.lab.lab1.controller;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.lab.lab1.dto.MessageRespDTO;
import ru.lab.lab1.exception.DatabaseException;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<?> handleDatabaseException(DatabaseException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    //если подпись не совпадает с вычисленной, то SignatureException
    //если подпись некорректная (не парсится) то MalformedJwtException
    //если подпись истекла по времени,  то ExpiredJwtException //todo почему то не ловит

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<?> handleSignatureException(SignatureException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<?> handleMalformedJwtException(MalformedJwtException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<?> handleExpiredJwtException(ExpiredJwtException e) {
        return new ResponseEntity<>(MessageRespDTO.builder().message(e.getMessage()).build(), HttpStatus.UNAUTHORIZED);
    }
}
