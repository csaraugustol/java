public class Jogador extends Atleta
{
    private int Numero;
    private int Posicao;
    private TimeFutebol TimeFutebol;

    public Jogador(String Nome, double Peso, int Numero, int Posicao){
        setNome("");
        setPeso(0.0);
        this.Numero = Numero;
        this.Posicao = Posicao;
    }

    public Jogador(){
    }

    public void setNumero(int PeNumeroso){
        this.Numero = Numero;
    }

    public int getNumero(){
        return Numero;
    }

    public void setPosicao(int Posicao){
        this.Posicao = Posicao;
    }

    public int getPosicao(){
        return Posicao;
    }
    
    public String posicao(){
    if(getPosicao() == 0)
    return "Goleiro";
    
    else if(getPosicao() == 1)
    return "Zaga";
    
    else if(getPosicao() == 2)
    return "Meio Campo";
    
    else if(getPosicao() == 3)
    return "Ataque";
    
    else
    return "";
    }

}


