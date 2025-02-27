package MODEL.DTO.REQUEST;

import MODEL.ENTITY.Endereco;
import jakarta.validation.constraints.NotBlank;

public record EnderecoRequestDTO (@NotBlank String cep, String rua, String numero, String bairro, String cidade, String estado) {
    public Endereco converter() {
        return Endereco.builder()
                .cep(cep)
                .rua(rua)
                .numero(numero)
                .bairro(bairro)
                .cidade(cidade)
                .estado(estado)
                .build();
    }
}
