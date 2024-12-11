package org._commons;

public class BodyModel<T> {

    private Integer app_status_code;
    private String app_status_name;
    private String app_status_message;
    private T data;

    public Integer getAppStatusCode() {
        return app_status_code;
    }

    public void setAppStatusCode(Integer appStatusCode) {
        this.app_status_code = appStatusCode;
    }

    public String getAppStatusName() {
        return app_status_name;
    }

    public void setAppStatusName(String appStatusName) {
        this.app_status_name = appStatusName;
    }

    public String getAppStatusMessage() {
        return app_status_message;
    }

    public void setAppStatusMessage(String appStatusMessage) {
        this.app_status_message = appStatusMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
