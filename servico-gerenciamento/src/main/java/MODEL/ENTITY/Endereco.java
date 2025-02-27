package MODEL.ENTITY;

import MODEL.DTO.RESPONSE.EnderecoResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer id;

    @NonNull
    @Column( nullable = false )
    private String cep;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    public EnderecoResponseDTO converter () {
        return EnderecoResponseDTO.builder()
                .cep(cep)
                .rua(rua)
                .numero(numero)
                .bairro(bairro)
                .cidade(cidade)
                .estado(estado)
                .build();
    }
}
