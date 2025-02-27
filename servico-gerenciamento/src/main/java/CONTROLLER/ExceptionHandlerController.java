package CONTROLLER;

import MODEL.DTO.RESPONSE.ExceptionResponseDTO;
import MODEL.EXCEPTIONS.CriarException;
import MODEL.EXCEPTIONS.NaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CriarException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCriarException(CriarException e) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(e.getMessage(), Instant.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ExceptionResponseDTO> handleNaoEncontradoException(NaoEncontradoException e) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(e.getMessage(), Instant.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler( NullPointerException.class)
    public ResponseEntity<ExceptionResponseDTO> handleNaoEncontradoException(NullPointerException e) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(e.getMessage(), Instant.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler( Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleNaoEncontradoException(Exception e) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(e.getMessage(), Instant.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
