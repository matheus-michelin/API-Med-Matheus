package med.matheus.API.Med.Matheus.repository;

import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
