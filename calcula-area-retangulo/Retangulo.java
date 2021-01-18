public class Retangulo
{
    private double base, altura;
    
    public Retangulo(){
    }
    
    public void setBase(double base){
    this.base = base;
    }
    public double getBase(){
    return base;
    }
    public void setAltura(double altura){
    this.altura = altura;
    }
    
    public double getAltura(){
    return altura;
    }
    
    public double calculaArea(){
    return getBase() * getAltura();
    }
}
