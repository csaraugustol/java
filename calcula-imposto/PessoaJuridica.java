
public class PessoaJuridica extends Pessoa
{
    private String cnpj;
    private Empresa empresa;
    public PessoaJuridica(){
        setNome("");
        setRendaBruta(0);
        setTipoPessoa("");
    }
    
      public void setCnpj(String cnpj){
    this.cnpj = cnpj;
    }
    public String getCnpj(){
    return this.cnpj;
    }
}
