import java.util.Scanner;
public class Principal
{

    public static void main(String args[]){

        Scanner leia = new Scanner(System.in);
        Triangulo triang = new Triangulo();

        System.out.print("Informe o valor do 1º lado: ");
        triang.setLado1(leia.nextDouble());
        System.out.print("Informe o valor do 2º lado: ");
        triang.setLado2(leia.nextDouble());
        System.out.print("Informe o valor do 3º lado: ");
        triang.setLado3(leia.nextDouble());
       // leia.nextLine();
        triang.verificaTriangulo();

    }
}
