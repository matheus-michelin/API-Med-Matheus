package med.matheus.API.Med.Matheus.DTO.PacientesDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;

public record AtualizarPacienteDTO(
        @NotNull
        Long id,

        @Email
        String email,

        @Pattern(regexp = "^\\d{10,11}$", message = "O telefone deve ter entre 10 e 11 dígitos")
        String telefone,

        @Valid
        DadosEndereco dadosEndereco) {
}
