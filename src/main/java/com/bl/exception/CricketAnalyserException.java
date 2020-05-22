package com.bl.exception;

 class CricketAnalserException extends RuntimeException {
    public enum ExceptionType {
        PLAYER_ROLE_NOT_FOUND,CRICKETER_FILE_PROBLEM, FILE_WRONG_HEADER, NO_CRICKETER_DATA;
    }

    public ExceptionType type;

    public CricketAnalserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketAnalserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CricketAnalserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}