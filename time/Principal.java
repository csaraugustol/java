import java.util.Scanner;
import java.util.ArrayList;
public class Principal
{
    public static void main (String[] args){

        Scanner leia = new Scanner(System.in);
        ArrayList<Jogador> jgds;

        TimeFutebol tf = new TimeFutebol("Nome","Cidade","Estado");

        tf.setNome("São Paulo");
        tf.setCidade("São Paulo");
        tf.setEstado("SP");

        Jogador jgd = new Jogador("Nome", 0.0, 0, 0);

        jgd.setNome("Ganso");
        jgd.setPeso(71);
        jgd.setNumero(10);
        jgd.setPosicao(2);
        tf.addJgd(jgd);
        Jogador joga = new Jogador("Nome", 0.0, 0, 0);
        joga.setNome("Rogério Ceni");
        joga.setPeso(78);
        joga.setNumero(1);
        joga.setPosicao(0);
        tf.addJgd(joga);
        
        
        System.out.println("Inserir Jogadores: ");
        while(true){
            Jogador j = new Jogador();
            
            System.out.println(" Nome Jogador: ");
            j.setNome(leia.next());
            System.out.println(" Peso: ");
            j.setPeso(leia.nextDouble());
            System.out.println(" Número: ");
            j.setNumero(leia.nextInt());
            System.out.println(" Posição(0 para Goleiro, 1 para Zaga, 2 para Meio Campo, 3 para Ataque): ");
            j.setPosicao(leia.nextInt());
            tf.addJgd(j);
            
            System.out.println(" Deseja adicionar mais jogadores: S/N ");
            if(leia.next().equalsIgnoreCase("N")){
                break;
            }

        }

     
    } 
}
