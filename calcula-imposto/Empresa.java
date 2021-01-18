import java.util.ArrayList;
public class Empresa
{
    private String nome; 
    private double rendaEmpresa;
    private ArrayList<Pessoa> func;
    private Pessoa pessoa;

    public Empresa(){
        func = new ArrayList<>();
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setRendaEmpresa(double rendaEmpresa){
        this.rendaEmpresa = rendaEmpresa;
    }

    public double getRendaEmpresa(){
        return this.rendaEmpresa;
    }

    public void addFunc(Pessoa pessoa){
        func.add(pessoa);
    }

    public double retornaImpostoPessoaJuridica(){
        double impostoPj = 0;
        for(int  i =0; i < func.size(); i++){
            if(func.get(i).getTipoPessoa().equalsIgnoreCase("pj")){
                impostoPj  = func.get(i).getRendaBruta() * 0.10;
            }
        } 

        return impostoPj;
    }

    public double retornaMaiorImposto(){
        int indice = posicaoMaiorImposto();
        double maiorImposto = 0;
        
            if(func.get(indice).getTipoPessoa().equalsIgnoreCase("pf")){
                if(func.get(indice).getRendaBruta() <= 1.400)
                {
                    maiorImposto = 0;
                }
                else if(func.get(indice).getRendaBruta() > 1.400 && func.get(indice).getRendaBruta() <= 2.100)
                {
                    maiorImposto = func.get(indice).getRendaBruta() * 0.10;
                }
                else if(func.get(indice).getRendaBruta() > 2.100 && func.get(indice).getRendaBruta() <= 2.800)
                {
                   maiorImposto = func.get(indice).getRendaBruta() * 0.15;
                }
                else if(func.get(indice).getRendaBruta() > 2.800 && func.get(indice).getRendaBruta() <= 3.600)
                {
                    maiorImposto = func.get(indice).getRendaBruta() * 0.25;
                }
                else
                {
                    maiorImposto = func.get(indice).getRendaBruta() * 0.30;
                }
            
        } 
        
        else {
        maiorImposto = func.get(indice).getRendaBruta() * 0.10;
        }
        
        return maiorImposto;

    }
    
    public double retornaMenorImposto(){
        int indice = posicaoMenorImposto();
        double menorImposto = 0;
        
            if(func.get(indice).getTipoPessoa().equalsIgnoreCase("pf")){
                if(func.get(indice).getRendaBruta() <= 1.400)
                {
                    menorImposto = 0;
                }
                else if(func.get(indice).getRendaBruta() > 1.400 && func.get(indice).getRendaBruta() <= 2.100)
                {
                    menorImposto = func.get(indice).getRendaBruta() * 0.10;
                }
                else if(func.get(indice).getRendaBruta() > 2.100 && func.get(indice).getRendaBruta() <= 2.800)
                {
                   menorImposto = func.get(indice).getRendaBruta() * 0.15;
                }
                else if(func.get(indice).getRendaBruta() > 2.800 && func.get(indice).getRendaBruta() <= 3.600)
                {
                    menorImposto = func.get(indice).getRendaBruta() * 0.25;
                }
                else
                {
                    menorImposto = func.get(indice).getRendaBruta() * 0.30;
                }
            
        } 
        
        else {
        menorImposto = func.get(indice).getRendaBruta() * 0.10;
        }
        
        return menorImposto;

    }
    
    public String imprimeMaior(){
    return "O funcionário que pagou mais imposto: " + func.get(posicaoMaiorImposto()).getNome() + ", pagou imposto R$: " + retornaMaiorImposto(); 
    }
    
    public String imprimeMenor(){
    return "O funcionário que pagou mais imposto: " + func.get(posicaoMenorImposto()).getNome() + ", pagou imposto R$: " + retornaMenorImposto(); 
    }

    /*public double retornaImpostoPessoaFisica(){
    double impostoPf = 0;
    for(int  i =0; i < func.size(); i++){
    if(func.get(i).getTipoPessoa().equalsIgnoreCase("pf")){
    if(func.get(i).getRendaBruta() <= 1.400)
    {
    return impostoPf = 0;
    }
    else if(func.get(i).getRendaBruta() > 1.400 && func.get(i).getRendaBruta() <= 2.100)
    {
    return impostoPf = func.get(i).getRendaBruta() * 0.10;
    }
    else if(func.get(i).getRendaBruta() > 2.100 && func.get(i).getRendaBruta() <= 2.800)
    {
    return impostoPf = func.get(i).getRendaBruta() * 0.15;
    }
    else if(func.get(i).getRendaBruta() > 2.800 && func.get(i).getRendaBruta() <= 3.600)
    {
    return impostoPf = func.get(i).getRendaBruta() * 0.25;
    }
    else
    {
    return impostoPf = func.get(i).getRendaBruta() * 0.30;
    }
    }
    } 

    return impostoPf;
    }

    public String pagouMaiorImposto(){
    String mImposto = "";
    double imposto = 0;
    int pos = 0;

    for(int i = 0; i < func.size(); i++){
    if(func.get(i).getRendaBruta() > imposto ){
    imposto = func.get(i).getRendaBruta();
    pos = i;
    }

    }
    return "Funcionário que pagou mais imposto, " + func.get(pos).getNome() + " de " + imposto + ;
    }
     */

    public int posicaoMaiorImposto(){
        double imposto = 0;
        int pos = 0;

        for(int i = 0; i < func.size(); i++){
            if(func.get(i).getRendaBruta() > imposto ){
                imposto = func.get(i).getRendaBruta();
                pos = i;
            }

        }
        return pos;
    }
    
    public int posicaoMenorImposto(){
        double menorImposto = func.get(0).getRendaBruta();
        int pos = 0;

        for(int i = 0; i < func.size(); i++){
            if(func.get(i).getRendaBruta() < menorImposto ){
                menorImposto = func.get(i).getRendaBruta();
                pos = i;
            }

        }
        return pos;
    }
}
