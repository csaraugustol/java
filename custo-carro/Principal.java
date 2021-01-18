import java.util.Scanner;
import java.text.DecimalFormat;
public class Principal
{
    public static void main(String args[]){
    
        Scanner leia = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        
        Carro carro = new Carro();
        
        System.out.print("Informe o custo de fábrica do carro: ");
        carro.setCustoFabrica(leia.nextDouble());
        System.out.print("Informe a porcentagem de imposto que será aplicada: ");
        carro.setPorcentImpos(leia.nextDouble());
        System.out.print("Agora, informe a porcentagem que será aplicada para revenda: ");
        carro.setPorcentDistri(leia.nextDouble());
        
        System.out.printf("O valor de custo ao consumidor será de R$ " + 
        (df.format(carro.calculaValorConsu())) + " reais.");
    }
}
