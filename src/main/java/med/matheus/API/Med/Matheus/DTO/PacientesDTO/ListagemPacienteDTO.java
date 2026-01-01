package med.matheus.API.Med.Matheus.DTO.PacientesDTO;

import med.matheus.API.Med.Matheus.domain.Paciente.Paciente;

public record ListagemPacienteDTO(String nome, String email, String telefone, String cpf) {

    public ListagemPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
