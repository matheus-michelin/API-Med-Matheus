package med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
