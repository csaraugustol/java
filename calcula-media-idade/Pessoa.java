
public class Pessoa
{
    int idadeH1, idadeH2, idadeM1, idadeM2;
    
    public Pessoa(){
    }
    
    public void setIdadeH1(int idadeH1){
    this.idadeH1 = idadeH1;
    }
    
    public int getIdadeH1(int idadeH2){
    return idadeH1;
    }
    
     public void setIdadeH2(int idadeH2){
    this.idadeH2 = idadeH2;
    }
    
    public int getIdadeH2(int idadeH2){
    return idadeH2;
    }
    
     public void setIdadeM1(int idadeM1){
    this.idadeM1 = idadeM1;
    }
    
    public int getIdadeM1(int idadeM2){
    return idadeM1;
    }
    
      public void setIdadeM2(int idadeM2){
    this.idadeM2 = idadeM2;
    }
    
    public int getIdadeM2(int idadeM2){
    return idadeM2;
    }
    
    
    public void CalculaIdade(){
        
        int maiorIdade=0, menorIdade = 0;

        if (idadeH1 > idadeH2 && idadeM1 < idadeM2){
            maiorIdade = idadeH1;
            menorIdade = idadeM1;

            System.out.println("Soma do Homem com maior idade e Mulher com menor idade: " + (maiorIdade + menorIdade));
            System.out.println("Produto do Homem com menor idade e Mulher com maior idade: " + (idadeH2 * idadeM2));
        }

        else if (idadeH1 > idadeH2 && idadeM1 > idadeM2){
            maiorIdade = idadeH1;
            menorIdade = idadeM2;

            System.out.println("Soma do Homem com maior idade e Mulher com menor idade: " + (maiorIdade + menorIdade) + " anos.");
            System.out.println("Produto do Homem com menor idade e Mulher com maior idade: " + (idadeH2 * idadeM1));
        }
        else if (idadeH2 > idadeH1 && idadeM1 < idadeM2){
            maiorIdade = idadeH2;
            menorIdade = idadeM1;

            System.out.println("Soma do Homem com maior idade e Mulher com menor idade: " + (maiorIdade + menorIdade));
            System.out.println("Produto do Homem com menor idade e Mulher com maior idade: " + (idadeH1 * idadeM2));
        }
        else{
            maiorIdade = idadeH2;
            menorIdade = idadeM2;

            System.out.println("Soma do Homem com maior idade e Mulher com menor idade: " + (maiorIdade + menorIdade));
            System.out.println("Produto do Homem com menor idade e Mulher com maior idade: " + (idadeH1 * idadeM1));
        }
    
    }
   
}
