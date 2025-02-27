package SERVICE;

import MODEL.DTO.REQUEST.MedicoRequestDTO;
import MODEL.DTO.RESPONSE.MedicoResponseDTO;
import MODEL.ENTITY.Medico;
import MODEL.EXCEPTIONS.CriarException;
import MODEL.EXCEPTIONS.NaoEncontradoException;
import REPOSITORY.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicoService {

    private MedicoRepository repository;

    public MedicoResponseDTO criarMedico( MedicoRequestDTO medicoDto ) {

        try {
            return repository.save( medicoDto.converter() ).conveter();
        } catch ( Exception e ) {
            throw new CriarException( e.getMessage() );
        }

    }

    public MedicoResponseDTO buscarMedico( Integer id ) {

        try {
            return repository.findById( id ).get().conveter();
        } catch ( Exception e ) {
            throw new NaoEncontradoException( e.getMessage() );
        }
    }

    public List<MedicoResponseDTO> listarMedicos() {

        try {
            return repository.findAll().stream().map( Medico::conveter ).toList();
        } catch ( Exception e ) {
            throw new NaoEncontradoException( e.getMessage() );
        }
    }

    public MedicoResponseDTO atualizarMedico( Integer id, MedicoRequestDTO medicoDto ) {

        try {

            if ( repository.existsById( id ) ) {
                return this.criarMedico( medicoDto );
            } else {
                throw new NaoEncontradoException( "Médico não encontrado" );
            }
        } catch ( Exception e ) {
            throw new NaoEncontradoException( e.getMessage() );
        }
    }

    public void deletarMedico( Integer id ) {

        try {
            repository.deleteById( id );
        } catch ( Exception e ) {
            throw new NaoEncontradoException( e.getMessage() );
        }
    }
}
