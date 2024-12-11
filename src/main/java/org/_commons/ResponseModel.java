package org._commons;

import java.util.Map;

public class ResponseModel<T> {

    private Integer statusCode;
    private Map<String,String> headers;
    private BodyModel<T> body;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public BodyModel<T> getBody() {
        return body;
    }

    public void setBody(BodyModel<T> body) {
        this.body = body;
    }
}
