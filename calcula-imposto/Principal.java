import java.util.Scanner;
public class Principal
{
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);

        Empresa emp = new Empresa();

        System.out.println("Nome Empresa: ");
        emp.setNome(leia.next());

        while(true){
            PessoaFisica pf = new PessoaFisica();
            PessoaJuridica pj = new PessoaJuridica(); 

            System.out.println("Pessoa: PF para Pessoa Fisíca ou PJ para Pessoa Jurídica");
            if(leia.next().equalsIgnoreCase("PF")){

                pf.setTipoPessoa("PF");
                System.out.println("PESSOA FISÍCA");
                System.out.println(" Informe o nome: ");
                pf.setNome(leia.next());
                System.out.println(" Informe a renda bruta: ");
                pf.setRendaBruta(leia.nextDouble());
                System.out.println(" Informe a idade: ");
                pf.setIdade(leia.nextInt());
                System.out.println(" Informe o CPF: ");
                pf.setCpf(leia.next());

                emp.addFunc(pf);

                System.out.println("Deseja adicionar mais funcionários: S/N ");
                if(leia.next().equalsIgnoreCase("N")){
                    break;
                }
            }
            else{
                pj.setTipoPessoa("PJ");
                System.out.println("PESSOA JURÍDICA");
                System.out.println(" Informe o nome: ");
                pj.setNome(leia.next());
                System.out.println(" Informe a renda bruta: ");
                pj.setRendaBruta(leia.nextDouble());
                System.out.println(" Informe o CNPJ: ");
                pj.setCnpj(leia.next());

                emp.addFunc(pj);

                System.out.println("Deseja adicionar mais funcionários: S/N ");
                if(leia.next().equalsIgnoreCase("N")){
                    break;
                }
            }

        }

        System.out.println(emp.imprimeMaior());
        System.out.println(emp.imprimeMenor());

    }
}
