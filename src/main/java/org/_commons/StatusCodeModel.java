package org._commons;

import java.util.Objects;

public final class StatusCodeModel {

    private Integer httpCode;
    private int appStatusCode;
    private String appStatusName;
    private String appStatusMessage;

    private StatusCodeModel(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusCodeModel that = (StatusCodeModel) o;
        return Objects.equals(appStatusName, that.appStatusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appStatusName);
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public int getAppStatusCode() {
        return appStatusCode;
    }

    public String getAppStatusName() {
        return appStatusName;
    }

    public String getAppStatusMessage() {
        return appStatusMessage;
    }

    private void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    private void setAppStatusCode(int appStatusCode) {
        this.appStatusCode = appStatusCode;
    }

    private void setAppStatusName(String appStatusName) {
        this.appStatusName = appStatusName;
    }

    private void setAppStatusMessage(String appStatusMessage) {
        this.appStatusMessage = appStatusMessage;
    }

    public static class Builder {

        private Integer httpCode;
        private int appStatusCode;
        private String appStatusName;
        private String appStatusMessage;

        public StatusCodeModel build() {
            final StatusCodeModel model = new StatusCodeModel();
            model.setHttpCode(this.httpCode);
            model.setAppStatusCode(this.appStatusCode);
            model.setAppStatusName(this.appStatusName);
            model.setAppStatusMessage(this.appStatusMessage);
            return model;
        }

        public Builder setHttpCode(Integer httpCode) {
            this.httpCode = httpCode;
            return this;
        }

        public Builder setAppStatusCode(int appStatusCode) {
            this.appStatusCode = appStatusCode;
            return this;
        }

        public Builder setAppStatusName(String appStatusName) {
            this.appStatusName = appStatusName;
            return this;
        }

        public Builder setAppStatusMessage(String appStatusMessage) {
            this.appStatusMessage = appStatusMessage;
            return this;
        }
    }
}
