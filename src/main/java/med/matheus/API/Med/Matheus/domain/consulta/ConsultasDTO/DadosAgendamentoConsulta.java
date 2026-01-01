package med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import med.matheus.API.Med.Matheus.domain.Medico.Especialidade;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        @JsonAlias("idMedico") Long idMedico,

        @NotNull
        @JsonAlias("idPaciente") Long idPaciente,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        @JsonAlias("date") LocalDateTime date,

        Especialidade especialidade
) {
}
