public class Pessoa
{
    String nome, tipoPessoa;
    double rendaBruta;
    Empresa empresa;
        
    public Pessoa(){
   
    }
    
    public void setNome(String nome){
    this.nome = nome;
    }
    public String getNome(){
    return this.nome;
    }
    
    public void setTipoPessoa(String tipoPessoa){
    this.tipoPessoa = tipoPessoa;
    }
    public String getTipoPessoa(){
    return this.tipoPessoa;
    }
    
      public void setRendaBruta(double rendaBruta){
    this.rendaBruta = rendaBruta;
    }
    public double getRendaBruta(){
    return this.rendaBruta;
    }
    
    public void calculaImposto(){
    
    }
    
}
