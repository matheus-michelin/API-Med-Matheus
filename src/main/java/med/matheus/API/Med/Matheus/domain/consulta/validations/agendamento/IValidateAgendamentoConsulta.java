package med.matheus.API.Med.Matheus.domain.consulta.validations.agendamento;

import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;

public interface IValidateAgendamentoConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
