package med.matheus.API.Med.Matheus.repository;

import med.matheus.API.Med.Matheus.DTO.MedicosDTO.CadastroMedicoDTO;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.CadastroPacienteDTO;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;
import med.matheus.API.Med.Matheus.domain.Medico.Especialidade;
import med.matheus.API.Med.Matheus.domain.Medico.Medico;
import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;
import med.matheus.API.Med.Matheus.domain.consulta.Consulta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deveria dar como resposta 'null' quando só houver um médico cadastrado não disponível na data")
    void escolherMedicoAletorioLivreNaData1() {
        //given
        var tercaAs8 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                .atTime(8, 0);

        //when
        var medico = cadastrarMedico("Arthur", "arthur@matheus.med", "123456", Especialidade.ORTOPEDIA);
        var paciente = cadastrarPaciente("Arthur", "arthur@matheus.paciente.med", "00000000000");
        cadastrarConsulta(medico, paciente, tercaAs8);

        //assert
        var medicoLivre = repository.escolherMedicoAleatorioLivreNaData(String.valueOf(Especialidade.ORTOPEDIA), tercaAs8);
        assertThat(medicoLivre).isNull();
    }


    @Test
    @DisplayName("Deveria dar como resposta um médico quando estiver disponível data")
    void escolherMedicoAletorioLivreNaData2() {
       //given
        var tercaAs8 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                .atTime(8, 0);

        //when
        var medico = cadastrarMedico("Arthur", "arthur@matheus.med", "123456", Especialidade.ORTOPEDIA);

        //assert
        var medicoLivre = repository.escolherMedicoAleatorioLivreNaData(String.valueOf(Especialidade.ORTOPEDIA), tercaAs8);
        assertThat(medicoLivre).isEqualTo(medico);
    }










    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.persist(new Consulta(null, medico, paciente, data));
    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private CadastroMedicoDTO dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
        return new CadastroMedicoDTO(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private CadastroPacienteDTO dadosPaciente(String nome, String email, String cpf) {
        return new CadastroPacienteDTO(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}