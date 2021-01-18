
public class PessoaFisica extends Pessoa
{
    private int idade;
    private String cpf;
    
    public PessoaFisica(){
        setNome("");
        setRendaBruta(0);
        setTipoPessoa("");
    }
    
      public void setIdade(int idade){
    this.idade = idade;
    }
    public int getIdade(){
    return this.idade;
    }
    
      public void setCpf(String cpf){
    this.cpf = cpf;
    }
    public String getCpf(){
    return this.cpf;
    }
    
}
