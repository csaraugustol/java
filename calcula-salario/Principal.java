import java.util.Scanner;

public class Principal
{
    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);
        Funcionario sal = new Funcionario();
        
        
        System.out.print("Hora trab: ");
        sal.setHoraTrab(leia.nextDouble());
        System.out.print("Valor hora: ");
        sal.setSalarioHora(leia.nextDouble());
        System.out.print("Dependentes: ");
        sal.setNumDependentes(leia.nextInt());
        
        System.out.println("  Salário Bruto: " + sal.setSalarioBruto());
        System.out.println("  Inss: " + sal.Inss());
        System.out.println("  IR: " + sal.IR());
        System.out.println("  Salário Liquído: " + sal.salarioLiquido());
        
    }
}
