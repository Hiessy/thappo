package org.thappo.service.model;

public class HealthCheck {

    public enum Status {
        OK, ERROR;
    }

    private Status status;
    private String message;
    private String version;

    public HealthCheck(Status status, String message, String version) {
        this.status = status;
        this.message = message;
        this.version = version;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getVersion() {
        return this.version;
    }

    public static class Builder {

        private Status status;
        private String message;
        private String version;

        public void setStatus(Status status) {
            this.status = status;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public HealthCheck build() {
            return new HealthCheck(this.status, this.message, this.version);
        }

    }
}