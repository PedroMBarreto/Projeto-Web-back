package ifba.com.br.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manipula exceções de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationExceptionDetails.ValidationError> validationErrors = new ArrayList<>();

        // Itera sobre todos os erros de validação
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            validationErrors.add(new ValidationExceptionDetails.ValidationError(fieldName, message));
        });

        // Constrói a resposta de erro usando o builder
        ValidationExceptionDetails exceptionDetails = new ValidationExceptionDetails.Builder()
                .timestamp(LocalDateTime.now()) // Timestamp
                .status(HttpStatus.BAD_REQUEST.value()) // Status HTTP 400
                .message("Erro de validação.") // Mensagem geral
                .details("Cheque os campos com erros.") // Detalhes adicionais
                .errors(validationErrors) // Lista de erros específicos
                .build();

        // Retorna a resposta com os erros no corpo
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    // Outros manipuladores de exceção, se necessário


// Captura exceções gerais, como NullPointerException, etc.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Ocorreu um erro inesperado: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
