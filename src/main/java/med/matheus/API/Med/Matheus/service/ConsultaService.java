package med.matheus.API.Med.Matheus.service;

import med.matheus.API.Med.Matheus.domain.Medico.Medico;
import med.matheus.API.Med.Matheus.domain.consulta.Consulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosDetalhamentoConsulta;
import med.matheus.API.Med.Matheus.domain.exception.ValidacaoException;
import med.matheus.API.Med.Matheus.repository.ConsultaRepository;
import med.matheus.API.Med.Matheus.repository.MedicoRepository;
import med.matheus.API.Med.Matheus.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    public ResponseEntity agendar(DadosAgendamentoConsulta dados) {
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente não existe!");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do medico não existe!");
        }

        var medico = escolherRandomMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null, medico, paciente, dados.date());
        repository.save(consulta);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

    private Medico escolherRandomMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

         if (dados.especialidade() == null){
             throw new NullPointerException("Especialidade é obrigatória quando médico não for escolhido");
         }

         return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.date());
    }
}
