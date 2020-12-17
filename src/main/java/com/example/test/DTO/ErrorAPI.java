package com.example.test.DTO;

import java.util.Objects;


public class ErrorAPI {
    String errorMsg;
    Integer errorCode;


    public ErrorAPI() {
    }

    public ErrorAPI(String errorMsg, Integer errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorAPI errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public ErrorAPI errorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ErrorAPI)) {
            return false;
        }
        ErrorAPI errorAPI = (ErrorAPI) o;
        return Objects.equals(errorMsg, errorAPI.errorMsg) && Objects.equals(errorCode, errorAPI.errorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMsg, errorCode);
    }

    @Override
    public String toString() {
        return "{" +
            " errorMsg='" + getErrorMsg() + "'" +
            ", errorCode='" + getErrorCode() + "'" +
            "}";
    }

  
}