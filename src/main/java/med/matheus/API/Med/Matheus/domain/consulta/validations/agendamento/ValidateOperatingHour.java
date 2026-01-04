package med.matheus.API.Med.Matheus.domain.consulta.validations.agendamento;

import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidateOperatingHour implements IValidateAgendamentoConsulta{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var beforeClinicOpens = dataConsulta.getHour() < 7;

        var afterClinicClose =  dataConsulta.getHour()  > 18;

        if (domingo || beforeClinicOpens || afterClinicClose){
            throw new IllegalArgumentException("Consulta fora do horário ou dia do funcionamento da clínica");
        }


    }
}
