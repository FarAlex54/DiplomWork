package com.example.api.util;

public class ProductErrorResponse {
    private String massage;

    public ProductErrorResponse(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
