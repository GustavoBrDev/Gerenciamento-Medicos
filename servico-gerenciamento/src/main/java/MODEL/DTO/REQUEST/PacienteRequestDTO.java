package MODEL.DTO.REQUEST;

import MODEL.ENTITY.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;


public record PacienteRequestDTO(@NotBlank String nome, String email, String telefone, @NotBlank String cpf, @NonNull @Valid EnderecoRequestDTO endereco ) {

    public Paciente converter () {
        return Paciente.builder()
                .nome(this.nome)
                .email(this.email)
                .telefone(this.telefone)
                .cpf(this.cpf)
                .endereco(this.endereco.converter())
                .build();
    }
}
