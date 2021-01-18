public class Aluno
{
   private double notaAluno;
   private Turma turma;
   
   public Aluno(){
    }
   
    public void setTurma(Turma turma){
    this.turma = turma;
    }
    
    public Turma getTurma(){
    return turma;
    }
    
   public void setNotaAluno(double notaAluno){
    this.notaAluno = notaAluno;
    }
    public double getNotaAluno(){
    return notaAluno;
    }
    
}
