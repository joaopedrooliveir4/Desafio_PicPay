package com.JoaoPedro.pipcpay_desafio.exception.model;

public class ApiError {

    private String title;
    private int status;
    private String message;
    private String timestamp = java.time.OffsetDateTime.now().toString();;

    public ApiError(String title, int status, String message) {
        this.title = title;
        this.status = status;
        this.message = message;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
