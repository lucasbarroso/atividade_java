package projeto.entidade;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private Integer id;
    private String nome;
    private Integer idade;
    private List<String> errors = new ArrayList<>();;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public List<String> getValidationErrors() {
        return errors;
    }

    public boolean isValid() {
        this.errors = new ArrayList<>();
        if (this.nome == null || this.nome.length() == 0) {
            this.errors.add("Nome inválido");
           
        }

        if(this.idade != null && this.idade < 0){
            this.errors.add("Idade Inválida");
        }
       return this.errors.isEmpty();
       
    }
    

}
