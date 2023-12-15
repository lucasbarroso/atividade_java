package projeto.rotas.Pessoas;

import projeto.entidade.Pessoa;
import projeto.service.ValidationException;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.Map;

public class AtualizaPessoas extends RoutePessoas {
    public static Route ATUALIZA_PESSOA = new AtualizaPessoas();
    @Override
    public Object handle(Request request, Response response) throws Exception {
        final Pessoa pessoa = gson.fromJson(request.body(), Pessoa.class);
        try {
            super.pessoaService.atualizarPessoa(pessoa);
            response.status(200);
            return "Atualizado";
        } catch (ValidationException e) {
            response.status(400);
            
            return gson.toJson(Map.of("no_update", e.getErros()));
            
            // TODO: handle exception
        }

    }
    
}
