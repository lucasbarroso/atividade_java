package projeto.rotas.Pessoas;
import java.util.Map;
import projeto.entidade.Pessoa;
import projeto.service.ValidationException;
import spark.Request;
import spark.Response;
import spark.Route;

public class DeletePessoas extends RoutePessoas {
    public static Route DELETE_PESSOA = new DeletePessoas();

    @Override
    public Object handle(Request request, Response response) throws Exception {
        final Pessoa pessoa = gson.fromJson(request.body(), Pessoa.class);
        try {
            super.pessoaService.deletarPessoa(pessoa);
            response.status(200);
            return "deletado";
        } catch (ValidationException e) {
            response.status(400);
            
            return gson.toJson(Map.of("no_deletes", e.getErros()));
            
            // TODO: handle exception
        }

    }
    
}
