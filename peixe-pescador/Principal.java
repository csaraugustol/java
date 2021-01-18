import java.util.Scanner;
import java.text.DecimalFormat;
public class Principal
{
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);

        Pescador pesc = new Pescador();
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Informe o valor que será acrescentado a cada kg de peixe que passar 50kg: ");
        pesc.setVlMulta(leia.nextDouble());

        while(true){
            Peixe peixe = new Peixe();
            
            System.out.println("Informe o nome do peixe: ");
            peixe.setNomePeixe(leia.next());
            System.out.println(" Informe o peso do(a) " + peixe.getNomePeixe() + ": ");
            peixe.setPeso(leia.nextDouble());

            pesc.addPeixe(peixe);

            System.out.println("Deseja adicionar mais peixes: (S) / (N)");
            if(leia.next().equalsIgnoreCase("N")){
                break;
            }

        }

        System.out.println("O pescador deve pagar R$ " + df.format(pesc.calculaMulta()) + " reais a mais pelo excesso de peso.");
    }
}
