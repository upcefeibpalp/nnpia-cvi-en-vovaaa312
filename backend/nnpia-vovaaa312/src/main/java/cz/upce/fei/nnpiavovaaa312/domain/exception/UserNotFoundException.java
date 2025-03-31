package cz.upce.fei.nnpiavovaaa312.domain.exception;

import cz.upce.fei.nnpiavovaaa312.domain.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
    }



    public UserNotFoundException(String message) {
        super(message);
    }
}