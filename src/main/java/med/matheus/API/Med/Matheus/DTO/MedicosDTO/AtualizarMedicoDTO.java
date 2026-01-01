package med.matheus.API.Med.Matheus.DTO.MedicosDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;

public record AtualizarMedicoDTO(
        @NotNull
        Long id,

        String nome,

        String telefone,

        @Valid
        DadosEndereco dadosEndereco) {
}
