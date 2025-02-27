package MODEL.ENTITY;

import MODEL.DTO.RESPONSE.MedicoResponseDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Medico {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @NonNull
    @Column ( nullable = false)
    private String nome;

    private String email;

    private String telefone;

    @NonNull
    @Column ( nullable = false, unique = true)
    private String crm;

    private String especialidade;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private Endereco endereco;

    public MedicoResponseDTO conveter () {
        return MedicoResponseDTO.builder()
                .id(id)
                .nome(nome)
                .email(email)
                .telefone(telefone)
                .crm(crm)
                .especialidade(especialidade)
                .endereco(endereco.converter())
                .build();
    }
}
