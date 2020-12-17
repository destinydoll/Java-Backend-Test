package com.example.test.DTO;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;


public class ResponseMsg {
    String responseMsg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    ErrorAPI error;


    public ResponseMsg() {
    }

    public ResponseMsg(String responseMsg, ErrorAPI error) {
        this.responseMsg = responseMsg;
        this.error = error;
    }

    public String getResponseMsg() {
        return this.responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public ErrorAPI getError() {
        return this.error;
    }

    public void setError(ErrorAPI error) {
        this.error = error;
    }

    public ResponseMsg responseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
        return this;
    }

    public ResponseMsg error(ErrorAPI error) {
        this.error = error;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResponseMsg)) {
            return false;
        }
        ResponseMsg responseMsg = (ResponseMsg) o;
        return Objects.equals(responseMsg, responseMsg.responseMsg) && Objects.equals(error, responseMsg.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseMsg, error);
    }

    @Override
    public String toString() {
        return "{" +
            " responseMsg='" + getResponseMsg() + "'" +
            ", error='" + getError() + "'" +
            "}";
    }

}
