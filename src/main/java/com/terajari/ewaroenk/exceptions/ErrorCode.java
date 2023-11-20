package com.terajari.ewaroenk.exceptions;

/**
 * An enumeration of error codes and associated error messages for order related validation errors.
 * @author github.com/terajari
 * @project https://github.com/terajari/ewaroenk
 * @created 2023-11-20
 */
public enum ErrorCode {
    GENERIC_ERROR("EWAROENK-0001", "The system is unable to process your request. Contact support administrator"),
    HTTP_MEDIATYPE_NOT_SUPPORTED("EWAROENK-0002", "The media type is not supported. Please use application/json or application/xml as 'Content-Type'header value"),
    HTTP_MESSAGE_NOT_WRITABLE("EWAROENK-0003", "Missing 'Accept' header. Please add 'Accept' header with 'application/json' or 'application/xml'"),
    HTTP_MEDIATYPE_NOT_ACCEPTABLE("EWAROENK-0004", "The media type is not acceptable. Please use application/json or application/xml as 'Accept'header value"),
    JSON_PARSE_ERROR("EWAROENK-0005", "The JSON data is not valid"),
    HTTP_MESSAGE_NOT_READABLE("EWAROENK-0006", "Make sure request payload should be a valid JSON or XML according to 'Content-Type' header");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
