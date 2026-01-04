package med.matheus.API.Med.Matheus.domain.consulta.validations.agendamento;

import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;
import med.matheus.API.Med.Matheus.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatePacienteAtivo implements IValidateAgendamentoConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
    }
}
