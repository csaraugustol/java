
public class Funcionario
{
   double horaTrab, salarioHora, salarioBruto, salarioLiq=0, iRenda;
    int numDependentes;
    
    
    
    public void setHoraTrab(double horaTrab){
        this.horaTrab = horaTrab;
    }

    public double getHoraTrab(){
        return horaTrab;
    }

    public void setSalarioHora(double salarioHora){
        this.salarioHora = salarioHora;
    }

    public double getSalarioHora(){
        return horaTrab;
    }

    public void setNumDependentes(int numDependentes){
        this.numDependentes = numDependentes;
    }

    public int getNumDependentes(){
        return numDependentes;
    }

    public double setSalarioBruto(){
        return salarioBruto = (horaTrab * salarioHora ) + (50 * numDependentes);
    }

    /*public double getSalarioBruto(){
    return salarioBruto;
    }*/

    public double Inss(){
        if(salarioBruto <= 1000){
            return salarioBruto * 8.5/100;
        }
        else{
            return salarioBruto * 9/100;
        }
    }

    /* public double getInss(){
    return inss;
    }*/

    public double IR(){
        if(salarioBruto <= 500){
            return 0;
        }
        else if(salarioBruto > 500 && salarioBruto <= 1000){
            return salarioBruto * 5/100;
        }
        else{
        return salarioBruto * 7/100;
        }
    }
    
    public double salarioLiquido(){
        return salarioBruto - Inss() - IR();
    }
}
