package CONTROLLER;

import MODEL.DTO.REQUEST.MedicoRequestDTO;
import MODEL.DTO.RESPONSE.MedicoResponseDTO;
import SERVICE.MedicoService;
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
@RequestMapping("/medicos")
public class MedicoController {

    private MedicoService service;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> criarMedico( @RequestBody @Valid MedicoRequestDTO medicoDto ) {

        try {
            MedicoResponseDTO medico = service.criarMedico( medicoDto );
            return new ResponseEntity<>( medico, HttpStatus.CREATED );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping
    public ResponseEntity<MedicoResponseDTO> atualizarMedico( @RequestBody @Valid MedicoRequestDTO medicoDto, @PathVariable @Positive @NotNull Integer id ) {

        try {
            MedicoResponseDTO medico = service.atualizarMedico( id, medicoDto );
            return new ResponseEntity<>( medico, HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listarMedicos() {

        try {
            List<MedicoResponseDTO> medicos = service.listarMedicos();
            return new ResponseEntity<>( medicos, HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> buscarMedico( @PathVariable @Positive @NotNull Integer id ) {

        try {
            MedicoResponseDTO medico = service.buscarMedico( id );
            return new ResponseEntity<>( medico, HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> deletarMedico( @PathVariable @Positive @NotNull Integer id ) {

        try {
            service.deletarMedico( id );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
