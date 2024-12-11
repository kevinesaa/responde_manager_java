package org._commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseBuilder {

    private final static String KEY_STATUS_CODE = "app_status_code";
    private final static String KEY_STATUS_NAME = "app_status_name";
    private final static String KEY_STATUS_MESSAGE = "app_status_message";
    private final static String KEY_ACCESS_CONTROL_ORIGIN = "Access-Control-Allow-Origin";
    private final static String KEY_ACCESS_CONTROL_CREDENTIALS = "Access-Control-Allow-Credentials";
    private final static String KEY_ACCESS_CONTROL_HEADERS = "Access-Control-Allow-Headers";
    private final static String KEY_ACCESS_CONTROL_METHODS = "Access-Control-Allow-Methods";


    private Integer httpCode;
    private Integer appStatusCode;
    private String appStatusName;
    private String appStatusMessage;
    private Map<String,String> headers;
    private Object data;


    public <T> ResponseBuilder setData(T data) {
        this.data = data;
        return this;
    }

    public ResponseBuilder setStatusModel(final StatusCodeModel statusModel) {

        this.setHttpCode(statusModel.getHttpCode());
        this.setAppStatusCode(statusModel.getAppStatusCode());
        this.setAppStatusName(statusModel.getAppStatusName());
        this.setAppStatusMessage(statusModel.getAppStatusMessage());

        return this;
    }

    public ResponseBuilder setHttpCode(final Integer httpCode) {
        this.httpCode = httpCode;
        return this;
    }

    public ResponseBuilder setAppStatusCode(final Integer appStatusCode) {
        this.appStatusCode = appStatusCode;
        this.putAdditionalHeader(KEY_STATUS_CODE,appStatusCode.toString());
        return this;
    }

    public ResponseBuilder setAppStatusName(final String appStatusName) {
        this.appStatusName = appStatusName;
        this.putAdditionalHeader(KEY_STATUS_NAME,appStatusName);
        return this;
    }

    public ResponseBuilder setAppStatusMessage(final String appStatusMessage) {
        this.appStatusMessage = appStatusMessage;
        this.putAdditionalHeader(KEY_STATUS_MESSAGE,appStatusMessage);
        return this;
    }

    public ResponseBuilder setControlOrigin() {
        this.setControlOrigin("*");
        return this;
    }

    public ResponseBuilder setControlOrigin(final String controlOrigin) {
        this.putAdditionalHeader(KEY_ACCESS_CONTROL_ORIGIN, controlOrigin);
        return this;
    }

    public ResponseBuilder setControlCredentials() {
        setControlCredentials(true);
        return this;
    }

    public ResponseBuilder setControlCredentials(final boolean controlCredential) {
        this.putAdditionalHeader(KEY_ACCESS_CONTROL_CREDENTIALS,Boolean.toString(controlCredential));
        return this;
    }

    public ResponseBuilder setControlHeaders() {
        this.putAdditionalHeader(KEY_ACCESS_CONTROL_HEADERS,"Content-Type");
        return this;
    }

    public ResponseBuilder setControlHeaders(final String controlHeaders) {
        this.putAdditionalHeader(KEY_ACCESS_CONTROL_HEADERS,controlHeaders);
        return this;
    }

    public ResponseBuilder setControlMethods(final List<String> methods) {
        final String controlMethods = String.join(",", methods).toUpperCase();
        this.putAdditionalHeader(KEY_ACCESS_CONTROL_METHODS, controlMethods);
        return this;
    }

    public ResponseBuilder putAdditionalHeader(final Map<String,String> headers) {
        headers.forEach(this::putAdditionalHeader);
        return this;
    }

    public ResponseBuilder putAdditionalHeader(final String key, final String value) {

        if(value != null) {
            if(this.headers == null) {
                this.headers = new HashMap<>();
            }
            this.headers.put(key,value);
        }

        return this;
    }

    public <T> ResponseModel<T> build() {

        final BodyModel<T>  body = new BodyModel<T>();;
        final ResponseModel<T> model = new ResponseModel<T>();

        body.setAppStatusCode(this.appStatusCode);
        body.setAppStatusName(this.appStatusName);
        body.setAppStatusMessage(this.appStatusMessage);
        body.setData((T)this.data);

        model.setStatusCode(this.httpCode);
        model.setHeaders(this.headers);
        model.setBody(body);

        return model;
    }
}
