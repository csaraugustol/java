import java.util.ArrayList;
public class Pescador
{

    private ArrayList<Peixe> peixe;
    private double vlMulta;

    public Pescador(){
        peixe = new ArrayList<Peixe>();
    }

    public void addPeixe(Peixe px){
        peixe.add(px);
    }

    public ArrayList<Peixe> getPeixe(){
        return this.peixe;
    }

    public void setVlMulta(double vlMulta){
        this.vlMulta = vlMulta;
    }

    public double getVlMulta(){
        return vlMulta;
    }

    public double pesoExcedido(){

        double pesoExcedido = 0, subtraiPeso = 0;

        for(int i=0; i < peixe.size(); i++){
            Peixe pxe = peixe.get(i);

            if (peixe.get(i).getPeso() > 50){
                subtraiPeso = pxe.getPeso() - 50;
                pesoExcedido += subtraiPeso;
            }

        }
        return pesoExcedido;
    }

    public double calculaMulta(){
        return pesoExcedido() * getVlMulta();

    }
}

