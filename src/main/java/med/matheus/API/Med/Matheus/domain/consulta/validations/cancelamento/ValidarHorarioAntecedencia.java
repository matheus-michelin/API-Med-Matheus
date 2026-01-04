package med.matheus.API.Med.Matheus.domain.consulta.validations.cancelamento;

import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosCancelamentoConsulta;
import med.matheus.API.Med.Matheus.domain.exception.ValidacaoException;
import med.matheus.API.Med.Matheus.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidateHorarioAntecedenciaDoCancelamento")
public class ValidarHorarioAntecedencia implements IValidateCancelamentoConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoConsulta dados){

        var consulta = repository.getReferenceById(dados.idConsulta());
        var now = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(now, consulta.getData()).toHours();

        if(diferencaEmHoras < 24){
            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedencia de 24 horas");
        }
    }
}
