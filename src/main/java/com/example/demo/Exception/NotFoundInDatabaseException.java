package com.example.demo.Exception;

public class NotFoundInDatabaseException extends Exception{
    public NotFoundInDatabaseException(String message){
        super(message);
    }

}
