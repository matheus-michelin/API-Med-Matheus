package med.matheus.API.Med.Matheus.repository;

import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query(value = "SELECT p.ativo FROM pacientes p WHERE p.id = :idPaciente", nativeQuery = true)
    Boolean findAtivoById(Long idPaciente);

    Page<Paciente> findAllByAtivoTrue(Pageable pageable);
}
