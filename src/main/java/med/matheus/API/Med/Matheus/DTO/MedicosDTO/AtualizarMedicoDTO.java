package med.matheus.API.Med.Matheus.DTO.MedicosDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;

public record AtualizarMedicoDTO(
        @NotNull
        Long id,

        String nome,

        @Pattern(regexp = "^\\d{10,11}$", message = "O telefone deve ter entre 10 e 11 dígitos")
        String telefone,

        @Valid
        DadosEndereco dadosEndereco) {
}
