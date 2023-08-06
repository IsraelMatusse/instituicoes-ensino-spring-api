package com.escolasapiapi.dtos;

public class ResponseAPI {
    private final boolean success;
    private final String message;
    private final Object data;

    public ResponseAPI(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}

