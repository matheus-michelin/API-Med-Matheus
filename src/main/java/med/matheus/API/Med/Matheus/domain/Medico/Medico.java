package med.matheus.API.Med.Matheus.domain.Medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.AtualizarMedicoDTO;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.CadastroMedicoDTO;
import med.matheus.API.Med.Matheus.domain.Endereco.Endereco;
import org.jetbrains.annotations.NotNull;

@Entity(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(@NotNull CadastroMedicoDTO dadosMedico) {
        this.ativo = true;
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.telefone = dadosMedico.telefone();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new Endereco(dadosMedico.dadosEndereco());
    }

    public void atualizarInformacoes(AtualizarMedicoDTO atualizarMedico) {

        if (atualizarMedico.nome() != null){
            this.nome = atualizarMedico.nome();
        }

        if (atualizarMedico.telefone() != null){
            this.telefone = atualizarMedico.telefone();
        }

        if (atualizarMedico.dadosEndereco() != null){
            this.endereco.atualizarInformacoes(atualizarMedico.dadosEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
