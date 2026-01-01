package med.matheus.API.Med.Matheus.DTO.PacientesDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;

public record AtualizarPacienteDTO(
        @NotNull
        Long id,

        String email,

        String telefone,

        @Valid
        DadosEndereco dadosEndereco) {
}
