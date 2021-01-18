import java.util.ArrayList;
public class TimeFutebol
{
    private String Nome, Cidade, Estado;
    private Jogador jogador;
    private ArrayList<Jogador> jgd;

    public TimeFutebol(String Nome, String Cidade, String Estado){
        jgd = new ArrayList<Jogador>();
        this.Nome = Nome;
        this.Cidade = Cidade;
        this.Estado = Estado;

    }

    public void addJgd(Jogador j){
        jgd.add(j);
    }

    public ArrayList<Jogador> getJogador(){
        return jgd;
    }

    public void setNome(String Nome){
        this.Nome = Nome;
    }

    public String getNome(){
        return Nome;
    }

    public void setCidade(String Cidade){
        this.Cidade = Cidade;
    }

    public String getCidade(){
        return Cidade;
    }

    public void setEstado(String Estado){
        this.Estado = Estado;
    }

    public String getEstado(){
        return Estado;
    }


}
