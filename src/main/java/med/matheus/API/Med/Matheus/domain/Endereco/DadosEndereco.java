package med.matheus.API.Med.Matheus.domain.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "^\\d{8}$", message = "O CEP não pode ter mais de 8 dígitos")
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String numero,

        String complemento) {
}
