package med.matheus.API.Med.Matheus.DTO.MedicosDTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;
import med.matheus.API.Med.Matheus.domain.Medico.Especialidade;

public record  CadastroMedicoDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "^\\d{11}$", message = "O telefone deve ter entre 10 e 11 dígitos")
        String telefone,

        @NotBlank
        @Pattern(regexp = "^\\d{4,6}$", message = "O CRM deve ter entre 4 e 6 dígitos")
        String crm,

        @NotNull
        Especialidade especialidade,


        @NotNull
        @Valid
        DadosEndereco dadosEndereco) {
}
