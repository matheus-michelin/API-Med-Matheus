package med.matheus.API.Med.Matheus.DTO.PacientesDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;

public record CadastroPacienteDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "^\\d{11}$", message = "O telefone deve ter entre 10 e 11 dígitos")
        String telefone,

        @NotBlank
        @Pattern(regexp = "^\\d{11}$", message = "O CPF deve ter 11 dígitos")
        String cpf,

        @NotNull
        @Valid
        DadosEndereco dadosEndereco) {
}
