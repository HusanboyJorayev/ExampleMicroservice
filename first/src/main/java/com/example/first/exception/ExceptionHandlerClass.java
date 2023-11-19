package com.example.first.exception;



import com.example.first.dto.ErrorDto;
import com.example.first.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler
    public ResponseEntity<ResponseDto<Void>> Exception(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                ResponseDto.<Void>builder()
                        .code(-3)
                        .message("Validation error")
                        .errors(
                                e.getBindingResult()
                                        .getFieldErrors()
                                        .stream()
                                        .map(fieldError -> {
                                            String filed = fieldError.getField();
                                            String message = fieldError.getDefaultMessage();
                                            return new ErrorDto(filed, message);
                                        }).toList()
                        )
                        .build()
        );
    }
}
