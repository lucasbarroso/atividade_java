package projeto.rotas.Pessoas;
import com.google.gson.Gson;

import projeto.service.PessoaService;
import spark.Route;

public abstract class RoutePessoas implements Route {//no momento que se torna abstract, precisaria as rotas desta classe ainda serem final?
    //TEMPO DO VIDEO 45:48
    public PessoaService pessoaService = new PessoaService();
    public Gson gson = new Gson();
    

    // public static class PostPessoas implements Route{

    //     @Override
    //     public Object handle(Request request, Response response) throws Exception {
            
    //         throw new UnsupportedOperationException("Unimplemented method 'handle'");
    //     }

    // }


    
    
}
