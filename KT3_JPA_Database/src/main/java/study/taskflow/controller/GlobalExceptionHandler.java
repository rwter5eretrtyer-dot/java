package study.taskflow.controller;

import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@ControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<Map<String,String>> invalid(Exception e){return ResponseEntity.badRequest().body(Map.of("error","Bad request","message",e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class)public ResponseEntity<Map<String,String>> validation(Exception e){return ResponseEntity.badRequest().body(Map.of("error","Validation failed","message","Invalid title"));}
}
