import java.util.Scanner;
public class Principal
{

    public static void main(String args[]){

        Scanner leia = new Scanner(System.in);    
        Pessoa p = new Pessoa();
        //int idadeH1, idadeH2, idadeM1, idadeM2;

        System.out.println("Informe a idade do 1º Homem: ");
        p.setIdadeH1(leia.nextInt());
        System.out.println("Informe a idade do 2º Homem: ");
        p.setIdadeH2(leia.nextInt());
        System.out.println("Informe a idade da 1ª Mulher: ");
        p.setIdadeM1(leia.nextInt());
        System.out.println("Informe a idade da 2ª Mulher: ");
        p.setIdadeM2(leia.nextInt());

        p.CalculaIdade();
    }
}
