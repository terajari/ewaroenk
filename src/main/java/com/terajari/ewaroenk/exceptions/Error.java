package com.terajari.ewaroenk.exceptions;

import org.apache.logging.log4j.util.Strings;

/**
 * Represents an error response.
 * @author github.com/terajari
 * @project https://github.com/terajari/ewaroenk
 * @created 2023-11-20
 */
public class Error {
    private static final long serialVersionUID = 1L;

    /**
     * Sets the custom error code, which is different from HTTP response
     */
    private String errCode;

    /**
     * human-readable error message
     */
    private String message;

    /**
     * HTTP status code
     */
    private Integer status;

    /**
     * url request that produces error
     */
    private String url = "Not Available";

    /**
     * request method that produces error
     */
    private String reqMethod = "Not Available";

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getErrCode() {
        return errCode;
    }
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getUrl() {
        return url;
    }
    
    /**
     * Sets the URL of the object.
     *
     * @param  url   the URL to be set
     * @return       the updated Error object
     */
    public Error setUrl(String url) {
        if (Strings.isNotBlank(url))
        {
            this.url = url;
        }
        
        return this;
    }
    public String getReqMethod() {
        return reqMethod;
    }

    /**
     * Sets the request method for the API call.
     *
     * @param  reqMethod  the request method to be set
     * @return            the updated Error object
     */
    public Error setReqMethod(String reqMethod) {
        if (Strings.isNotBlank(reqMethod))
        {
            this.reqMethod = reqMethod;
        }
        
        return this;
    }

    
}
