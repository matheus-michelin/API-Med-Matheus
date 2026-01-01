package med.matheus.API.Med.Matheus.domain.Paciente;


import jakarta.persistence.*;
import lombok.*;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.AtualizarPacienteDTO;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.CadastroPacienteDTO;
import med.matheus.API.Med.Matheus.domain.Endereco.Endereco;
import med.matheus.API.Med.Matheus.converter.SmallIntBooleanConveter;

@Entity(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private Endereco endereco;

    @Convert(converter = SmallIntBooleanConveter.class)
    private Boolean ativo;

    public Paciente(CadastroPacienteDTO dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new Endereco(dadosPaciente.dadosEndereco());
    }

    public void atualizarInformacoesPaciente(AtualizarPacienteDTO atualizarPaciente){

        if(atualizarPaciente.email() != null){
            this.email = atualizarPaciente.email();
        }

        if (atualizarPaciente.telefone() != null){
            this.telefone = atualizarPaciente.telefone();
        }

        if(atualizarPaciente.dadosEndereco() != null){
            this.endereco.atualizarInformacoes(atualizarPaciente.dadosEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
