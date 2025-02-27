package MODEL.DTO.RESPONSE;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record MedicoResponseDTO( Integer id, String nome, String email, String telefone, String crm, String especialidade, EnderecoResponseDTO endereco ) {
}
