import java.util.Scanner;
public class Principal
{
    public static void main(String args[]){
    
        Scanner leia = new Scanner(System.in);
        Idade idade = new Idade();
        
        System.out.println("CONVERTER IDADE EM DIAS:");
        System.out.println("Informe a idade: ");
        idade.setId(leia.nextInt());
        System.out.println("Informe a quantidade de meses: ");
        idade.setMes(leia.nextInt());
        System.out.println("Informe a quantidade de dias: ");
        idade.setDia(leia.nextInt());
        
        System.out.println("A idade informa equivale a "
        + idade.calculaIdadeEmDias() + " dias.");
    
    }
   
}
