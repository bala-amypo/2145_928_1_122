// package com.example.demo.exception;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public Map<String, String> handleValidationErrors(
//             MethodArgumentNotValidException ex) {

//         Map<String, String> errors = new HashMap<>();

//         ex.getBindingResult().getFieldErrors()
//                 .forEach(error ->
//                         errors.put(error.getField(), error.getDefaultMessage())
//                 );

//         return errors;
//     }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     @ResponseStatus(HttpStatus.NOT_FOUND)
//     public Map<String, String> handleNotFound(
//             ResourceNotFoundException ex) {

//         return Map.of("error", ex.getMessage());
//     }

//     @ExceptionHandler(DuplicateResourceException.class)
//     @ResponseStatus(HttpStatus.CONFLICT)
//     public Map<String, String> handleDuplicate(
//             DuplicateResourceException ex) {

//         return Map.of("error", ex.getMessage());
//     }

//     @ExceptionHandler(InvalidDateException.class)
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public Map<String, String> handleInvalidDate(
//             InvalidDateException ex) {

//         return Map.of("error", ex.getMessage());
//     }

//     @ExceptionHandler(Exception.class)
//     @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//     public Map<String, String> handleGeneralError(Exception ex) {

//         return Map.of(
//                 "error", "Internal server error",
//                 "message", ex.getMessage()
//         );
//     }
// }
package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegal(IllegalArgumentException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Internal server error");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
