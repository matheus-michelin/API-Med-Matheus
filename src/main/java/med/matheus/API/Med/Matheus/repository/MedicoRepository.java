package med.matheus.API.Med.Matheus.repository;

import jakarta.validation.constraints.Future;
import med.matheus.API.Med.Matheus.domain.Medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    @Query(value = """
    SELECT * 
    FROM medicos m
    WHERE m.ativo = true
      AND m.especialidade = :especialidade
      AND m.id NOT IN (
          SELECT c.medico_id 
          FROM consultas c
          WHERE c.data = :data
      )
    ORDER BY random()
    LIMIT 1
""", nativeQuery = true)
    Medico escolherMedicoAleatorioLivreNaData(@Param("especialidade") String especialidade, @Future LocalDateTime data);


    Boolean existsByIdAndAtivoTrue(Long idMedico);
}
