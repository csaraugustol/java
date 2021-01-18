import java.util.ArrayList;
public class Turma
{
    private String nomeTurma;
    private double nota;
    private ArrayList<Aluno> aluno;

    public Turma(){
        aluno = new ArrayList<Aluno>();
    }

    public Turma(String nome){
        this.nomeTurma = nome;
        aluno = new ArrayList<Aluno>();
    }

    public void addAluno(Aluno al){
        aluno.add(al);
    }

    public ArrayList<Aluno> getAluno(){
        return this.aluno;

    }

    public void setNomeTurma(String nomeTurma){
        this.nomeTurma = nomeTurma;
    }

    public String getNomeTurma(){
        return nomeTurma;
    }

   
    public double media(){
        double somaNotas=0;

        for(int i=0; i < aluno.size(); i++){
            Aluno al = aluno.get(i);

            somaNotas += al.getNotaAluno();
        }

        return somaNotas / aluno.size();

    }

    public int acimaMedia(){
        int contAlunosAcimaMedia = 0;

        for(int i=0; i < aluno.size(); i++){
            Aluno al = aluno.get(i);

            if(aluno.get(i).getNotaAluno() > media() ){
                contAlunosAcimaMedia++;
            }

        }

        return contAlunosAcimaMedia;

    }
}
