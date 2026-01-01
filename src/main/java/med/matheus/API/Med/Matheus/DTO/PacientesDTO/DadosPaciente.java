package med.matheus.API.Med.Matheus.DTO.PacientesDTO;

import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;

public record DadosPaciente(Long id, String nome, String email, String telefone, String cpf) {

    public DadosPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
