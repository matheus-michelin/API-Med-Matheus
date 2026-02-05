package med.matheus.API.Med.Matheus.domain.consulta;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.matheus.API.Med.Matheus.domain.Medico.Medico;
import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime time) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.data = time;
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

    @Column(name = "ativa")
    private Boolean ativa;

    private LocalDateTime data;

    public void cancelar(MotivoDoCancelamento motivo, Boolean status) {
        this.motivoDoCancelamento = motivo;
        this.ativa = status;
    }
}
