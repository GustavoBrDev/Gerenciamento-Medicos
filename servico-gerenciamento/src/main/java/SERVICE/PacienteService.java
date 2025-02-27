package SERVICE;

import MODEL.DTO.REQUEST.PacienteRequestDTO;
import MODEL.DTO.RESPONSE.PacienteResponseDTO;
import MODEL.ENTITY.Paciente;
import MODEL.EXCEPTIONS.CriarException;
import MODEL.EXCEPTIONS.NaoEncontradoException;
import REPOSITORY.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService {

    private PacienteRepository repository;

    public PacienteResponseDTO criarPaciente(PacienteRequestDTO paciente) {

        try {
            return repository.save( paciente.converter()).converter();
        } catch (Exception e) {
            throw new CriarException(e.getMessage());
        }
    }

    public PacienteResponseDTO buscarPaciente(Integer id) {

        try {
            return repository.findById(id).get().converter();
        } catch (Exception e) {
            throw new NaoEncontradoException(e.getMessage());
        }
    }

    public List<PacienteResponseDTO> buscarTodosPacientes() {

        try {
            return repository.findAll().stream().map(Paciente::converter).toList();
        } catch (Exception e) {
            throw new NaoEncontradoException(e.getMessage());
        }
    }

    public PacienteResponseDTO atualizarPaciente(Integer id, PacienteRequestDTO paciente) {

        try {

            if (repository.existsById(id)) {
                return this.criarPaciente(paciente);
            } else {
                throw new NaoEncontradoException("Paciente não encontrado");
            }

        } catch (Exception e) {
            throw new NaoEncontradoException(e.getMessage());
        }
    }

    public void deletarPaciente(Integer id) {

        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new NaoEncontradoException(e.getMessage());
        }
    }
}
