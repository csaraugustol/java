import java.util.Calendar;
public class Empregado
{
    int codEmp, anoContra, anoNasc;
    
    public Empregado(){
    }

    public void setCodEmp(int codEmp){
        this.codEmp = codEmp;   
    }

    public int getCodEmp(){
        return codEmp;
    }

    public void setAnoContra(int anoContra){
        this.anoContra = anoContra;   
    }

    public int getAnoContra(){
        return anoContra;
    }

    public void setAnoNasc(int anoNasc){
        this.anoNasc = anoNasc;   
    }

    public int getAnoNasc(){
        return anoNasc;
    }

    public void VerificaAposentadoria(){

        Calendar year = Calendar.getInstance();
        int anoAtual = year.get(Calendar.YEAR);
        int idade = anoAtual - anoNasc;

        if (idade >= 65){
            System.out.println(" Idade: " + idade + "   Tempo de trabalho: " + (anoAtual - anoContra));
            System.out.println("  Requerer aposentadoria.");
        }
        else if (anoAtual - anoContra >= 30){
            System.out.println(" Idade: " + idade + "   Tempo de trabalho: " + (anoAtual - anoContra));
            System.out.println("  Requerer aposentadoria.");
        }

        else if (idade >= 60 && anoAtual - anoContra >= 25){
            System.out.println(" Idade: " + idade + "   Tempo de trabalho: " + (anoAtual - anoContra));
            System.out.println("  Requerer aposentadoria.");
        }

        else{
            System.out.println(" Idade: " + idade + "   Tempo de trabalho: " + (anoAtual - anoContra));
            System.out.println("  Não requerer.");
        }

    }

}
