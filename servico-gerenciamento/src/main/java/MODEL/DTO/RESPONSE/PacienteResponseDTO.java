package MODEL.DTO.RESPONSE;

import lombok.Builder;

@Builder
public record PacienteResponseDTO ( Integer id,  String nome, String cpf, String email, String telefone, EnderecoResponseDTO endereco ) {
}
