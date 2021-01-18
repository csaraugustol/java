public class Peixe
{
    public Peixe(){
    }
    
   private String nomePeixe;
   private double peso;
   private Pescador pescador;
   
   public void setNomePeixe(String nomePeixe){
    this.nomePeixe = nomePeixe;
    }
    
    public String getNomePeixe(){
    return nomePeixe;
    }
    
     public void setPeso(double peso){
    this.peso = peso;
    }
    
    public double getPeso(){
    return peso;
    }
}
