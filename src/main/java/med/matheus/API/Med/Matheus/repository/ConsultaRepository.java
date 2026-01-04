package med.matheus.API.Med.Matheus.repository;

import jakarta.validation.constraints.Future;
import med.matheus.API.Med.Matheus.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    Boolean existsByMedicoIdAndData(Long idMedico, @Future LocalDateTime data);

    Boolean existsByPacienteIdAndDataBetween(Long idPaciente, @Future LocalDateTime data, LocalDateTime ultimoHorario);
}
