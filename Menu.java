import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    public void lerOpcao(){
        System.out.println("0) Fechar menu");
        System.out.println("1) Cadastrar livro");
        System.out.println("2) Remover livro");
        System.out.println("3) Cadastrar cliente");
        System.out.println("4) Remover cliente");
        System.out.println("5) Alugar livro ");
        System.out.println("6) Devolver livro alugado");
        System.out.println("7) Livros disponiveis para aluguel");
        System.out.println("8) Clientes cadastrados");
    }

    public void executarOpcao(){

        int opcao;
        do{
            lerOpcao();
            System.out.println("Digite a opcao que gostaria de realizar");
            opcao = Integer.parseInt(scan.nextLine());

            switch(opcao) {
                case 1:
                    biblioteca.cadastrarLivro();
                    break;

                case 2:
                    biblioteca.removerLivro();
                    break;

                case 3:
                    biblioteca.cadastrarCliente();
                    break;
                case 4:
                    biblioteca.removerCliente();
                    break;
                case 5:
                    biblioteca.alugarLivro();
                    break;
                case 6:
                    biblioteca.clienteDevolveLivro();
                    break;
                case 7:
                    biblioteca.exibirInformacoesDosLivros();
                    break;
                case 8:
                    biblioteca.imprimirDadosClientes();
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }

        }while(opcao != 0);


    }
}
