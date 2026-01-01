package med.matheus.API.Med.Matheus.domain.exception;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String idDoPacienteNãoExiste) {
        super(idDoPacienteNãoExiste);
    }
}
