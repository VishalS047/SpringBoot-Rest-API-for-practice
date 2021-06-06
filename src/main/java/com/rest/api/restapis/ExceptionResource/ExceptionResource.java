package com.rest.api.restapis.ExceptionResource;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResource {
    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus status;
    
   
    public HttpStatus getNotFound() {
        return status;
    }   

    public void setNotFound(HttpStatus status) {
        this.status = status;
    }

    public ExceptionResource(Date timestamp, String message, String details, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.status = status;
    }

      public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
}
