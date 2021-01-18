
public class Idade
{
   private int id, mes, dia;
   
   public Idade(){
    }
   
   public void setId(int id){
    this.id = id;
    }
    
    public int getId(){
    return id;
    }
    
    public void setMes(int mes){
    this.mes = mes;
    }
    
    public int getMes(){
    return mes;
    }
    
     public void setDia(int dia){
    this.dia = dia;
    }
    
    public int getDia(){
    return dia;
    }
    
    public int calculaIdadeEmDias(){
    return (id * 365) + (mes * 30) + dia;
    }
}

