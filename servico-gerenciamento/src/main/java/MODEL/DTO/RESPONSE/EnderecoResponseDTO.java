package MODEL.DTO.RESPONSE;

import lombok.Builder;

@Builder
public record EnderecoResponseDTO( String cep, String rua, String numero, String bairro, String cidade, String estado) {
}
