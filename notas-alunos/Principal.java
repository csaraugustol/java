import java.util.Scanner;
import java.util.ArrayList;
public class Principal
{

    public static void main(String args[]){

        Scanner leia = new Scanner(System.in);
        Turma turma = new Turma();
        
        System.out.println("INFORME O NOME DA TURMA: ");
        turma.setNomeTurma(leia.nextLine());

        ArrayList<Aluno> al;
        while(true){
            Aluno aluno = new Aluno();

            System.out.println(" Informe a nota do aluno: ");
            aluno.setNotaAluno(leia.nextDouble());

            turma.addAluno(aluno);

            System.out.println(" Deseja adicionar mais notas: (S)im ou (N)ão");
            if(leia.next().equalsIgnoreCase("N") ){
                break;
            }


        }
        
        
        System.out.println("   A média da turma foi " + turma.media() + " pontos. " + turma.acimaMedia() + 
        " alunos conseguiram nota acima da média.");
    }
}
