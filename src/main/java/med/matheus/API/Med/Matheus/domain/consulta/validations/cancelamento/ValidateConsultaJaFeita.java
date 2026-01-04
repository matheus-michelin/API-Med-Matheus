package med.matheus.API.Med.Matheus.domain.consulta.validations.cancelamento;

import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosCancelamentoConsulta;
import med.matheus.API.Med.Matheus.domain.exception.ValidacaoException;
import med.matheus.API.Med.Matheus.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidateConsultaJaFeita implements IValidateCancelamentoConsulta{

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {

        var agora = LocalDateTime.now();

        var consulta = repository.findById(dados.idConsulta())
                .orElseThrow(() -> new ValidacaoException("Consulta não encontrada"));


        if (consulta.getData().isBefore(agora)){
            consulta.setAtiva(false);
            repository.save(consulta);

            throw new ValidacaoException("Consulta já realizada e marcada como inativa. Cancelamento não permitido.");


        }

    }
}
