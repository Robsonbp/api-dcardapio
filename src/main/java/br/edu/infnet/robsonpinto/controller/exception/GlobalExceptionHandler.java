package br.edu.infnet.robsonpinto.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoOpcaoInvalidoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoOpcaoNaoEncontradoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoProdutoInvalidoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoProdutoNaoEncontradoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.OpcaoInvalidaException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.OpcaoNaoEncontradaException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoInvalidoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoNaoEncontradoException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ProdutoInvalidoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(ProdutoInvalidoException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.BAD_REQUEST.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	
	@ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(ProdutoNaoEncontradoException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(GrupoProdutoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(GrupoProdutoNaoEncontradoException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(GrupoProdutoInvalidoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(GrupoProdutoInvalidoException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(GrupoOpcaoInvalidoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(GrupoOpcaoInvalidoException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(GrupoOpcaoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(GrupoOpcaoNaoEncontradoException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(OpcaoNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(OpcaoNaoEncontradaException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(OpcaoInvalidaException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(OpcaoInvalidaException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errors.put("Messagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
