package projeto.rotas.Pessoas;

import java.util.List;



import projeto.entidade.Pessoa;
import spark.Request;
import spark.Response;
import spark.Route;

public class GetPessoas extends RoutePessoas { //esse seria o nome da classe?
    public static Route GET_PESSOAS = new GetPessoas();

        @Override
        public Object handle(Request req, Response resp) throws Exception {
            String nome = req.queryParams( "nome");
            List<Pessoa> pessoas = pessoaService.buscarPessoas(nome);
            return gson.toJson(pessoas);
            // System.out.println(pessoas);
            // return pessoas;
            // throw new UnsupportedOperationException("Unimplemented method 'handle'");
        }
    
}
