public class Atleta
{
    protected String Nome;
    private double Peso;
    
    public Atleta(){
       
    }
    
    public void setNome(String Nome){
    this.Nome = Nome;
    }
    
    public String getNome(){
    return Nome;
    }
    
    public void setPeso(double Peso){
    this.Peso = Peso;
    }
    
    public double getPeso(){
    return Peso;
    }
}
