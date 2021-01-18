import java.lang.String;
public class Livro
{
    private int codigo, numPag;
    private String nomeObra, nomeAutor, palavraChave, assunto, editora;
    boolean ehDoado = true;
    private Biblioteca biblioteca;
    
    public Livro(){
    }
    
    
    public void setBiblioteca(Biblioteca biblioteca){
    this.biblioteca = biblioteca;
    }
    
    public Biblioteca getBiblioteca(){
    return biblioteca;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
    
    public void setNomeObra(String nomeObra){
        this.nomeObra = nomeObra;
    }

    public String getNomeObra(){
        return nomeObra;
    }

    public void setNomeAutor(String nomeAutor){
        this.nomeAutor = nomeAutor;
    }

    public String getNomeAutor(){
        return nomeAutor;
    }

    public void setEditora(String editora){
        this.editora = editora;
    }

    public String getEditora(){
        return editora;
    }

     public void setEhDoado(boolean ehDoado){
        this.ehDoado = ehDoado;
           }

    public boolean getEhDoado(){
        return ehDoado;
    }

    public void setNumPag(int numPag){
        this.numPag = numPag;
    }

    public int getNumPag(){
        return numPag;
    }

    public void setPalavraChave(String palavraChave){
        this.palavraChave = palavraChave;
    }

    public String getPalavraChave(){
        return palavraChave;
    }

    public void setAssunto(String assunto){
        this.assunto = assunto;
    }

    public String getAssunto(){
        return assunto;
    }

    }

        



