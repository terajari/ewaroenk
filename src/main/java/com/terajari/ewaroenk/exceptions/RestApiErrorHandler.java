package com.terajari.ewaroenk.exceptions;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestApiErrorHandler {
    private final MessageSource messageSource;

    public RestApiErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(HttpServletRequest request, Exception ex, Locale locale) {
        Error error = ErrorUtils.createError(ErrorCode.GENERIC_ERROR.getMessage(), ErrorCode.GENERIC_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR.value())
            .setUrl(request.getRequestURI())
            .setReqMethod(request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotSupportedException(HttpServletRequest request, HttpMediaTypeNotSupportedException ex, Locale locale) {
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getMessage(), ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getCode(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
            .setUrl(request.getRequestURI())
            .setReqMethod(request.getMethod());
        
        return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Error> handleHttpMessageNotWritableException(HttpServletRequest request, HttpMessageNotWritableException ex, Locale locale) {
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getMessage(), ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getCode(), HttpStatus.BAD_REQUEST.value())
            .setUrl(request.getRequestURI())
            .setReqMethod(request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotAcceptableException(HttpServletRequest request, HttpMediaTypeNotAcceptableException ex, Locale locale) {
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MEDIATYPE_NOT_ACCEPTABLE.getMessage(), ErrorCode.HTTP_MEDIATYPE_NOT_ACCEPTABLE.getCode(), HttpStatus.NOT_ACCEPTABLE.value())
            .setUrl(request.getRequestURI())
            .setReqMethod(request.getMethod());
        
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Error> handleJsonParseException(HttpServletRequest request, JsonParseException ex, Locale locale) {
        Error error = ErrorUtils.createError(ErrorCode.JSON_PARSE_ERROR.getMessage(), ErrorCode.JSON_PARSE_ERROR.getCode(), HttpStatus.BAD_REQUEST.value())
            .setUrl(request.getRequestURI())
            .setReqMethod(request.getMethod());
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException ex, Locale locale) {
        Error error = ErrorUtils.createError(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getMessage(), ErrorCode.HTTP_MESSAGE_NOT_READABLE.getCode(), HttpStatus.BAD_REQUEST.value())
            .setUrl(request.getRequestURI())
            .setReqMethod(request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
