package MODEL.DTO.REQUEST;

import MODEL.ENTITY.Medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoRequestDTO(@NotBlank String nome, String email, String telefone, @NotBlank String crm, String especialidade, @NotNull @Valid EnderecoRequestDTO endereco) {

    public Medico converter () {
        return Medico.builder()
                .nome(this.nome)
                .email(this.email)
                .telefone(this.telefone)
                .crm(this.crm)
                .especialidade(this.especialidade)
                .endereco(this.endereco.converter())
                .build();
    }
}
