package br.com.challenge.voteservice.service;

import org.springframework.http.HttpStatus;


public abstract class BaseException extends Exception {

    private HttpStatus status;

    public BaseException(String message, HttpStatus status){
        super(message);

        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
