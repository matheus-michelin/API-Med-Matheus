package med.matheus.API.Med.Matheus.service;

import med.matheus.API.Med.Matheus.domain.Medico.Medico;
import med.matheus.API.Med.Matheus.domain.consulta.Consulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosCancelamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosDetalhamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.MotivoDoCancelamento;
import med.matheus.API.Med.Matheus.domain.consulta.validations.agendamento.IValidateAgendamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.validations.cancelamento.IValidateCancelamentoConsulta;
import med.matheus.API.Med.Matheus.domain.exception.ValidacaoException;
import med.matheus.API.Med.Matheus.repository.ConsultaRepository;
import med.matheus.API.Med.Matheus.repository.MedicoRepository;
import med.matheus.API.Med.Matheus.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<IValidateAgendamentoConsulta> validations;

    @Autowired
    private List<IValidateCancelamentoConsulta> validationsC;


    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente não existe!");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do medico não existe!");
        }

        validations.forEach(v -> v.validar(dados));

        var medico = escolherRandomMedico(dados);

        if(medico == null){
            throw new ValidacaoException("Não tem nenhum médico disponível nessa data");
        }

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());

        var consulta = new Consulta(null, medico, paciente, dados.data());

        repository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);

    }

    private Medico escolherRandomMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

         if (dados.especialidade() == null){
             throw new NullPointerException("Especialidade é obrigatória quando médico não for escolhido");
         }

         return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade().name(), dados.data());
    }


    public void cancelarConsulta(DadosCancelamentoConsulta dados) {
        if(!repository.existsById(dados.idConsulta())){
            throw new ValidacaoException("Id da consulta informado não existe");
        }

        validationsC.forEach(v -> v.validar(dados));

        var consulta = repository.getReferenceById(dados.idConsulta());

        consulta.cancelar(MotivoDoCancelamento.valueOf(dados.motivo()), Boolean.valueOf(dados.ativa()));


    }
}
