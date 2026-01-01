package med.matheus.API.Med.Matheus.controller;

import jakarta.validation.Valid;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.AtualizarPacienteDTO;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.CadastroPacienteDTO;
import med.matheus.API.Med.Matheus.DTO.PacientesDTO.ListagemPacienteDTO;
import med.matheus.API.Med.Matheus.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid CadastroPacienteDTO pacienteDTO, UriComponentsBuilder uriBulder){

      return service.cadastrarPaciente(pacienteDTO, uriBulder);
    }


    @GetMapping
    public ResponseEntity<Page<ListagemPacienteDTO>> listarPacientes(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable){
        return service.listarPacientes(pageable);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(AtualizarPacienteDTO atualizarPaciente){

        return service.atualizarPaciente(atualizarPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirPacientes(@PathVariable Long id){
        return service.excluirPaciente(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharPacientes(@PathVariable Long id){
        return  service.detalharPacientes(id);
    }
}


