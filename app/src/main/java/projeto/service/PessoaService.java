package projeto.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.io.RuntimeIOException;



import projeto.entidade.Pessoa;
import projeto.repositorio.PessoaRepositorio;


//  import static java.util.Object.requireNonNull; //não funciona?

public class PessoaService { // valida o que chega nas operações do Crud
    private PessoaRepositorio repo = new PessoaRepositorio();

    public List<Pessoa> buscarPessoas(String nome) {
      
        // return repo.findByNome(Objects.requireNonNull(nome, "Nome não pode ser nulo"));//IMPORTANTE: java.Objects parece que não existe nessa maquina, porquê?
        
        
        if (nome == null) {
            throw new IllegalArgumentException("O parâmetro 'nome' não pode ser nulo");
        }

        return repo.findByNome(nome);
       

    }

    public void salvarPessoa(Pessoa pessoa) throws ValidationException {
        // System.out.println(pessoa);
        if(pessoa.isValid()){
            repo.save(pessoa);
        }
        else{
            List<String> erros = pessoa.getValidationErrors();
            
            throw new ValidationException(erros);

        }

    }   
     public void deletarPessoa(Pessoa pessoa) throws ValidationException {
        // System.out.println(pessoa);
        if(pessoa.isValid()){
            repo.delete(pessoa);
        }
        else{
            List<String> erros = pessoa.getValidationErrors();
            
            throw new ValidationException(erros);

        }

    }   
    public void atualizarPessoa(Pessoa pessoa) throws ValidationException{
        if(pessoa.isValid()){
            repo.update(pessoa);
        }
        else{
             List<String> erros = pessoa.getValidationErrors();
            
            throw new ValidationException(erros);
        }
    }
    

}
