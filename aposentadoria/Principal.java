import java.util.Scanner;
public class Principal
{
    
    public static void main(String args[]){
        
        Scanner leia = new Scanner(System.in);

        Empregado emp = new Empregado();
        
        System.out.println("Dados no funcionário");
        System.out.println("Informe o código: ");
        emp.setCodEmp(leia.nextInt());
        System.out.println("Informe ano de nascimento: ");
        emp.setAnoNasc(leia.nextInt());
        System.out.println("Informe o ano de ingresso na empresa: ");
        emp.setAnoContra(leia.nextInt());

        emp.VerificaAposentadoria();

    }
}
