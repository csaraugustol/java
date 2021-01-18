import java.util.Scanner;
import java.util.ArrayList;
public class Principal{
    public static void main(String args[]){

        Scanner leia = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("INFORME O NOME DA BIBLIOTECA: ");
        biblioteca.setNomeBiblioteca(leia.nextLine());

        ArrayList<Livro> l;

        while(true){
            Livro livro = new Livro();

            System.out.print(" Informe o código: ");
            livro.setCodigo(leia.nextInt());
            System.out.print(" Informe o nome da obra: ");
            livro.setNomeObra(leia.next());
            System.out.print(" Informe o nome  do autor: ");
            livro.setNomeAutor(leia.next());
            System.out.print(" Informe o nome da Editora: ");
            livro.setEditora(leia.next());
            System.out.print("Foi doada( (S)im ou (N)ão ): ");
            livro.setEhDoado(leia.next().equalsIgnoreCase("S"));
            System.out.print(" Informe o número de páginas: ");
            livro.setNumPag(leia.nextInt());
            System.out.print(" Informe uma palavra chave: ");
            livro.setPalavraChave(leia.next());
            System.out.print(" Informe um assunto: ");
            livro.setAssunto(leia.next());

            biblioteca.addLivro(livro);

            System.out.println(" Deseja adicionar mais livros: (S)im ou (N)ão");
            if(leia.next().equalsIgnoreCase("N") ){
                break;
            }

        }

        
        //System.out.print("Quantidade de obras doadas: " + biblioteca.contasObrasDoadas());
        biblioteca.contaObrasDoadas();

    }

}
