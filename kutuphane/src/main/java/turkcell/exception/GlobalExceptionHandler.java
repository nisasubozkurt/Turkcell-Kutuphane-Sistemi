package turkcell.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import turkcell.dto.ErrorResponse;
import turkcell.dto.ValidationErrorResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. İş Mantığı Hatalarını Yakalar (BusinessException)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        ErrorResponse error = new ErrorResponse(
                "İş Akış Hatası", 
                "BUSINESS_RULE_VIOLATION", 
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 2. Doğrulama Hatalarını Yakalar (@Valid hataları)
    // Hocanın istediği {argument, [message]} yapısı tam olarak burası
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleValidationException(MethodArgumentNotValidException ex) {
        List<ValidationErrorResponse> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationErrorResponse(
                        error.getField(), 
                        List.of(error.getDefaultMessage())))
                .collect(Collectors.toList());

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    // 3. Beklenmedik Genel Hataları Yakalar (Opsiyonel ama profesyonel durur)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "Sistem Hatası",
                "INTERNAL_SERVER_ERROR",
                "Beklenmedik bir hata oluştu: " + ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}