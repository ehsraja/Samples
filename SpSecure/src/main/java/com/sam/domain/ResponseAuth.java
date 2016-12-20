package com.sam.domain;

public class ResponseAuth {

    private int code;

    private String message;

    private ErrorAuth error;

    public ResponseAuth(int code, String message, ErrorAuth error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorAuth getError() {
        return error;
    }

    public void setError(ErrorAuth error) {
        this.error = error;
    }
}
