import java.util.Scanner;
public class Principal
{

    public static void main(String args[]){

        Scanner leia = new Scanner(System.in);
        Retangulo retangulo = new Retangulo();

        System.out.print("Informe o valor da base: ");
        retangulo.setBase(leia.nextDouble());
        System.out.print("Informe o valor da altura: ");
        retangulo.setAltura(leia.nextDouble());
        
        System.out.print("Valor da área: " + retangulo.calculaArea());

    }
}