package med.matheus.API.Med.Matheus.service;

import med.matheus.API.Med.Matheus.DTO.PacientesDTO.AtualizarPacienteDTO;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.CadastroPacienteDTO;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.DadosPaciente;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.ListagemPacienteDTO;
import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;
import med.matheus.API.Med.Matheus.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public ResponseEntity cadastrarPaciente(CadastroPacienteDTO pacienteDTO, UriComponentsBuilder uriBuilder){

        var paciente = new Paciente(pacienteDTO);

        repository.save(new Paciente(pacienteDTO));

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.ok(uri);
    }


    public ResponseEntity<Page<ListagemPacienteDTO>> listarPacientes(Pageable pageable) {

        var page = repository.findAll(pageable).map(ListagemPacienteDTO::new);
        return ResponseEntity.ok(page);
    }


    public ResponseEntity atualizarPaciente(AtualizarPacienteDTO atualizarPaciente) {

        var paciente = repository.getReferenceById(atualizarPaciente.id());

        paciente.atualizarInformacoesPaciente(atualizarPaciente);

        return ResponseEntity.ok(new DadosPaciente(paciente));
    }


    public ResponseEntity excluirPaciente(Long id) {

        var pacientes = repository.getReferenceById(id);

        pacientes.excluir();

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity detalharPacientes(Long id) {

        var paciente = repository.getReferenceById(id);

        return  ResponseEntity.ok(new DadosPaciente(paciente));
    }
}
