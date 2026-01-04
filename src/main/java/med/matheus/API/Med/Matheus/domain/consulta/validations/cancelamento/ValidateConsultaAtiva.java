package med.matheus.API.Med.Matheus.domain.consulta.validations.cancelamento;

import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosCancelamentoConsulta;
import med.matheus.API.Med.Matheus.domain.exception.ValidacaoException;
import med.matheus.API.Med.Matheus.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateConsultaAtiva implements IValidateCancelamentoConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoConsulta dados) {
        var consultaAtiva = repository.findById(dados.idConsulta())
                .orElseThrow(() -> new ValidacaoException("Consulta não encontrada"));

        if(!consultaAtiva.getAtiva()){
            throw new ValidacaoException("Não é possivel cancelar uma consulta já cancelada!");
        }
    }
}
