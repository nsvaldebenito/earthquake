package com.earthquake.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 5076566797461030082L;
	@Getter
    private final HttpStatus httpStatus;

    public BusinessException(){
        super();
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(HttpStatus httpStatus){
        super();
        this.httpStatus = httpStatus;
    }
    public BusinessException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

    public  BusinessException(String message, Throwable cause){
        super(message, cause);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public  BusinessException(String message){
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(Throwable cause){
        super(cause);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
