package projeto.rotas.Pessoas;

import java.util.Map;

import projeto.entidade.Pessoa;
import projeto.service.ValidationException;
import spark.Request;
import spark.Response;
import spark.Route;

public class PostPessoas extends RoutePessoas {
    public static Route POST_PESSOAS = new PostPessoas();

    @Override
    public Object handle(Request request, Response response) throws Exception {
        final Pessoa pessoa = gson.fromJson(request.body(), Pessoa.class);
        try {
            super.pessoaService.salvarPessoa(pessoa);
            response.status(200);
            return "OK";
        } catch (ValidationException e) {
            response.status(400);
            
            return gson.toJson(Map.of("errouu", e.getErros()));
            
            // TODO: handle exception
        }

    }

}
