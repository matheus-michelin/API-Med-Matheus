package med.matheus.API.Med.Matheus.DTO.MedicosDTO;

import med.matheus.API.Med.Matheus.domain.Endereco.Endereco;
import med.matheus.API.Med.Matheus.domain.Medico.Especialidade;
import med.matheus.API.Med.Matheus.domain.Medico.Medico;

public record DadosMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
