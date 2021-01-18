import java.util.Scanner;
public class Principal
{
    public static void main(String args[]){
    Scanner leia = new Scanner(System.in);
    
    Graus temp = new Graus();
    
    System.out.println("Informe a tempetura em Celsius: ");
    temp.setCel(leia.nextDouble());
 
    
    System.out.println(temp.getCel() + "ºC corresponde a " + temp.calculaTemp() + "ºF.");
    
    }
}
