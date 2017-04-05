package org.thappo.api.user.models.response;

import java.util.List;

import org.thappo.commons.model.Cause;

public class ErrorResponseDTO
    extends AbstractResponseDTO {

    private static final long serialVersionUID = 1L;

    private final Integer code;
    private final String exception;
    private final String message;
    private final List<Cause> causes;

    public ErrorResponseDTO(Integer code, String message, String exception, List<Cause> causes) {
        this.code = code;
        this.message = message;
        this.exception = exception;
        this.causes = causes;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getException() {
        return this.exception;
    }

    public List<Cause> getCauses() {
        return this.causes;
    }

    public static class Builder {

        private Integer code;
        private String message;
        private String exception;
        private List<Cause> causes;

        public Builder setCode(Integer code) {
            this.code = code;
            return this;
        }

        public Builder setException(String exception) {
            this.exception = exception;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public void setCauses(List<Cause> causes) {
            this.causes = causes;
        }

        public ErrorResponseDTO build() {
            return new ErrorResponseDTO(this.code, this.message, this.exception, this.causes);
        }
    }

    @Override
    public String toString() {
        return "ErrorResponseDTO [code=" + this.code + ", exception=" + this.exception + ", message=" + this.message
            + ", causes=" + this.causes + "]";
    }

}
