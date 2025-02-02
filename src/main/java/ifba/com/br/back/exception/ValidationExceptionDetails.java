package ifba.com.br.back.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationExceptionDetails {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String details;
    private List<ValidationError> errors;

    // Constructor privado para builder pattern
    private ValidationExceptionDetails(Builder builder) {
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.message = builder.message;
        this.details = builder.details;
        this.errors = builder.errors;
    }

    // Getters

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    // Classe interna para representar o erro específico
    public static class ValidationError {
        private String field;
        private String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        // Getters
        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

    // Builder Pattern
    public static class Builder {
        private LocalDateTime timestamp;
        private int status;
        private String message;
        private String details;
        private List<ValidationError> errors;

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder errors(List<ValidationError> errors) {
            this.errors = errors;
            return this;
        }

        public ValidationExceptionDetails build() {
            return new ValidationExceptionDetails(this);
        }
    }
}
