public class Carro
{
    double custoFabrica, porcentImpos, porcentDistri;
    
    public Carro(){
    }

    public void setCustoFabrica(double custoFabrica){
        this.custoFabrica = custoFabrica;
    }

    public double getCustoFabrica(){
        return custoFabrica;
    }

    public void setPorcentImpos(double porcentImpos){
        this.porcentImpos = porcentImpos;
    }

    public double getPorcentImpos(){
        return porcentImpos;
    }

    public void setPorcentDistri(double porcentDistri){
        this.porcentDistri = porcentDistri;
    }

    public double getPorcentDistri(){
        return porcentDistri;
    }

    
    public double calculaValorConsu(){
        return custoFabrica +  (custoFabrica * (porcentDistri / 100)) + (custoFabrica * (porcentImpos / 100));

    }
}
