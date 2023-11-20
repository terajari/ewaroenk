package com.terajari.ewaroenk.exceptions;

public class ErrorUtils {

    private ErrorUtils() {
    }

    public static Error createError(String message, String errorCode, Integer status) {
        Error error = new Error();
        error.setMessage(message);
        error.setErrCode(errorCode);
        error.setStatus(status);
        return error;
    }
}
