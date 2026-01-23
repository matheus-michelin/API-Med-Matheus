
package med.matheus.API.Med.Matheus.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.AtualizarMedicoDTO;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.CadastroMedicoDTO;
import med.matheus.API.Med.Matheus.DTO.MedicosDTO.ListagemMedicoDTO;
import med.matheus.API.Med.Matheus.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoService service;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMedico(@RequestBody @Valid CadastroMedicoDTO dadosMedico, UriComponentsBuilder uriBuilder){

      return service.cadastrarMedico(dadosMedico, uriBuilder);

    }


    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDTO>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return service.listarMedicos(pageable);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarInformacaoMedico(@RequestBody @Valid AtualizarMedicoDTO atulizarMedico){
       return service.atualizarInformacaoMedico(atulizarMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirMedicos(@PathVariable Long id){
       return service.excluirMedicos(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMedico(@PathVariable Long id){
        return service.detalharMedico(id);
    }


}
