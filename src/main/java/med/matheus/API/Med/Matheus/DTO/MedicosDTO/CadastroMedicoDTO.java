package med.matheus.API.Med.Matheus.DTO.MedicosDTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.matheus.API.Med.Matheus.domain.Endereco.DadosEndereco;
import med.matheus.API.Med.Matheus.domain.Medico.Especialidade;

public record CadastroMedicoDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,


        @NotNull
        @Valid
        DadosEndereco dadosEndereco) {
}
