package projeto.service;

import java.util.List;

public class ValidationException extends Exception {

    final private List<String> erros;

    public ValidationException(List<String> erros) {
        super(erros.toString());
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }
}
