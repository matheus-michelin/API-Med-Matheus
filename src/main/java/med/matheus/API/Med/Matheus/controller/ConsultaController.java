package med.matheus.API.Med.Matheus.controller;

import jakarta.validation.Valid;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosCancelamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosDetalhamentoConsulta;
import med.matheus.API.Med.Matheus.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamentoConsulta dados){

        var dto = service.agendar(dados);

        return ResponseEntity.ok(dto);

    }

    @PostMapping("/cancelar")
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dados){

      service.cancelarConsulta(dados);

      return ResponseEntity.noContent().build();
    }
}
