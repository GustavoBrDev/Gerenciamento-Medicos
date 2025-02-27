package MODEL.ENTITY;

import MODEL.DTO.RESPONSE.PacienteResponseDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Paciente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @NonNull
    @Column( nullable = false)
    private String nome;

    private String email;

    private String telefone;

    @NonNull
    @Column ( nullable = false, unique = true)
    private String cpf;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private Endereco endereco;

    public PacienteResponseDTO converter() {
        return PacienteResponseDTO.builder()
                .id(id)
                .nome(nome)
                .email(email)
                .telefone(telefone)
                .cpf(cpf)
                .endereco(endereco.converter())
                .build();
    }

}
