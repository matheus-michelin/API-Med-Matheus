package med.matheus.API.Med.Matheus.DTO.MedicosDTO;

import med.matheus.API.Med.Matheus.domain.Medico.Especialidade;
import med.matheus.API.Med.Matheus.domain.Medico.Medico;

public record ListagemMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {


    public ListagemMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}


