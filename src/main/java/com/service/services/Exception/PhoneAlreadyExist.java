package com.service.services.Exception;

public class PhoneAlreadyExist extends RuntimeException{
    public PhoneAlreadyExist(String msg){
       super(msg);
    }
}
