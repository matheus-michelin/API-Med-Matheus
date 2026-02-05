package med.matheus.API.Med.Matheus.controller;

import med.matheus.API.Med.Matheus.domain.Medico.Especialidade;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosAgendamentoConsulta;
import med.matheus.API.Med.Matheus.domain.consulta.ConsultasDTO.DadosDetalhamentoConsulta;
import med.matheus.API.Med.Matheus.service.ConsultaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoConsulta> dadosAgendamentoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoJson;

    @MockitoBean
    private ConsultaService service;


    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void agendar1() throws Exception {

        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacões estao válidas")
    @WithMockUser
    void agendar2() throws Exception {

        var data = LocalDateTime.now().plusHours(7);
        var especialidade = Especialidade.CARDIOLOGIA;

        var dadosDet = new DadosDetalhamentoConsulta(null, 2l, 5l, data);

        when(service.agendar(any())).thenReturn(dadosDet);


        var response = mvc.perform(post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosAgendamentoJson.write(
                                new DadosAgendamentoConsulta(2l, 5l, data, especialidade)
                        ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonExpected = dadosDetalhamentoJson.write(
                new DadosDetalhamentoConsulta(null, 2l, 5l, data)
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo((jsonExpected));
    }
}