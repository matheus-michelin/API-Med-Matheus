package med.matheus.API.Med.Matheus.domain.consulta;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.matheus.API.Med.Matheus.domain.Medico.Medico;
import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime time){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoDoCancelamento motivoDoCancelamento;

    @Column(name = "status_consulta")
    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    private LocalDateTime data;

    public void cancelar(MotivoDoCancelamento motivo, StatusConsulta status) {
        this.motivoDoCancelamento = motivo;
        this.status = status;
    }
}
