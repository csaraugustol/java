public class Graus
{
    private double cel;
    
    public Graus(){
    }

    public void setCel(double cel){
        this.cel = cel;
    }

    public double getCel(){
        return cel;
    }
    
    public double calculaTemp(){
    return ((cel * 9)/5 )+32;
    }
}
