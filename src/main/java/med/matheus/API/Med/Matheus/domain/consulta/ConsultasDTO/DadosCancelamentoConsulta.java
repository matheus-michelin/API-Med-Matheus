package med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotBlank
        String motivo,

        @NotBlank
        String ativa) {
}
