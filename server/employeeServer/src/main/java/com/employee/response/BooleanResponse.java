package com.employee.response;

public class BooleanResponse {
    private boolean success;

    public BooleanResponse(boolean success){
        this.success=success;
    }
    public boolean isSuccess() {
        return success;
    }
}
