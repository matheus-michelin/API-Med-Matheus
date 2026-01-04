package med.matheus.API.Med.Matheus.domain.consulta.validations.cancelamento;

import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosCancelamentoConsulta;

public interface IValidateCancelamentoConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
