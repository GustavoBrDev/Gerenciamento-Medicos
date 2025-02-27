package CONTROLLER;

import MODEL.DTO.REQUEST.PacienteRequestDTO;
import MODEL.DTO.RESPONSE.PacienteResponseDTO;
import SERVICE.PacienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criarPaciente( @RequestBody @Valid PacienteRequestDTO pacienteDto ) {

        try {
            PacienteResponseDTO paciente = service.criarPaciente( pacienteDto );
            return new ResponseEntity<>( paciente, HttpStatus.CREATED );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente( @RequestBody @Valid PacienteRequestDTO pacienteDto, @PathVariable @Positive @NotNull Integer id ) {

        try {
            PacienteResponseDTO paciente = service.atualizarPaciente( id, pacienteDto );
            return new ResponseEntity<>( paciente, HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> buscarTodosPacientes() {

        try {
            List<PacienteResponseDTO> pacientes = service.buscarTodosPacientes();
            return new ResponseEntity<>( pacientes, HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<PacienteResponseDTO> buscarPaciente( @PathVariable @Positive @NotNull Integer id ) {

        try {
            PacienteResponseDTO paciente = service.buscarPaciente( id );
            return new ResponseEntity<>( paciente, HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Void> deletarPaciente( @PathVariable @Positive @NotNull Integer id ) {

        try {
            service.deletarPaciente( id );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

}
