import java.util.ArrayList;
public class Biblioteca
{
    private String nomeBiblioteca;
    
    private ArrayList<Livro> livro;

    public Biblioteca(){
        livro = new ArrayList<Livro>();
    }

    public void addLivro(Livro l){
        livro.add(l);
    }

    public ArrayList<Livro> getLivro(){
        return this.livro;

    }

    public void setNomeBiblioteca(String nomeBiblioteca){
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public String getNomeBiblioteca(){
        return nomeBiblioteca;
    }

    public void contaObrasDoadas(){
        int contObrasDoadas = 0;
      

        for(int i=0; i < livro.size(); i++){
            Livro l = livro.get(i);

            if(livro.get(i).ehDoado == true){
                contObrasDoadas++;

            }

        }
        System.out.print("Quantidade de obras doadas: " + contObrasDoadas);
    }


}

