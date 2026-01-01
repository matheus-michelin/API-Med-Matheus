package med.matheus.API.Med.Matheus.service;

import jakarta.validation.Valid;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.AtualizarMedicoDTO;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.CadastroMedicoDTO;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.DadosMedico;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.ListagemMedicoDTO;
import med.matheus.API.Med.Matheus.domain.Medico.Medico;
import med.matheus.API.Med.Matheus.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;


    public ResponseEntity cadastrarMedico(@RequestBody @Valid CadastroMedicoDTO dadosMedico, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dadosMedico);

        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosMedico(medico));
    }

    public ResponseEntity<Page<ListagemMedicoDTO>> listarMedicos(Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(ListagemMedicoDTO::new);

        return ResponseEntity.ok(page);
    }

    public ResponseEntity atualizarInformacaoMedico(AtualizarMedicoDTO atualizarMedico) {

        var medico = repository.getReferenceById(atualizarMedico.id());
        medico.atualizarInformacoes(atualizarMedico);

        return ResponseEntity.ok(new DadosMedico(medico));
    }

    public ResponseEntity excluirMedicos(Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity detalharMedico(Long id) {
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosMedico(medico));
    }
}
