import java.util.ArrayList;
import java.util.Scanner;
public class Biblioteca {
    Scanner scan = new Scanner(System.in);
     ArrayList<Livro> colecaoLivro = new ArrayList<>();
     ArrayList<Cliente> listaDeClientes = new ArrayList<>();

    public void cadastrarLivro() {
        if(colecaoLivro.size() == 1000) {
            System.out.println("Nao e possivel cadastrar mais livros");

        } else {

            System.out.println("Digite as informacoes do livro");
            System.out.println("Titulo: ");
            String titulo = scan.nextLine();
            System.out.println("Autor: ");
            String autor = scan.nextLine();
            System.out.println("Editora: ");
            String editora = scan.nextLine();
            System.out.println("Data de publicação: ");
            String dataPublicao = scan.nextLine();

            for (Livro value : colecaoLivro) {
                if (value.getTitulo().equals(titulo)) {
                    System.out.println("Livro ja existe");
                    break;
                }
            }
            Livro livro = new Livro(titulo, autor, editora, dataPublicao);
            colecaoLivro.add(livro);
        }
    }

    public void removerLivro() {
        System.out.println("Digite o titulo do livro para ser removido");
        String tituloRemovivel = scan.nextLine();
        for(int i = 0; i < colecaoLivro.size(); i++){
            if(colecaoLivro.get(i).getTitulo().equals(tituloRemovivel)){
                colecaoLivro.remove(i);
                System.out.println("Livro removido com sucesso!");
                    break;
            }
        }
        System.out.println("Livro não encontrado ou já removido da lista!");
    }
    public void cadastrarCliente() {
        System.out.println("Informe os dados do cliente");
        System.out.println("Nome: ");
            String nome = scan.nextLine();
        System.out.println("Cpf: ");
            long cpf = Long.parseLong(scan.nextLine());

        for (Cliente listaDeCliente : listaDeClientes) {
            if (cpf == listaDeCliente.getCpf()) {
                System.out.println("O cliente já foi cadastrado");
                return;
            }
        }
        Cliente cliente = new Cliente(nome, cpf);
        listaDeClientes.add(cliente);
    }
    private Cliente encontrarCliente(long cpf){
        for (Cliente listaDeCliente : listaDeClientes) {
            if (listaDeCliente.getCpf() == cpf) {
                return listaDeCliente;
            }
        }
        return null;
    }

    private Livro encontrarLivro(String titulo){
        for (Livro livro : colecaoLivro) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void removerCliente() {

        System.out.println("Digite o CPF do cliente para ser removido");
            long cpfRemovivel = Long.parseLong(scan.nextLine());

        for (Cliente c: listaDeClientes) {
            if (cpfRemovivel == c.getCpf()) {
                listaDeClientes.remove(c);
                System.out.println("Cliente removido com sucesso! ");
                    break;
            }
        }
        System.out.println("O cliente não existe ou já foi removido");
    }

    public void alugarLivro() {

        System.out.println("Qual é o CPF de quem vai alugar o livro?");
            long cpf = Long.parseLong(scan.nextLine());
        Cliente cliente = encontrarCliente(cpf);

        System.out.println("Qual é o título do livro que será alugado?");
            String titulo = scan.nextLine();
        Livro livro = encontrarLivro(titulo);

        if((cliente != null) && (livro != null)) {
            if (cliente.checarPodeAlugar2(livro)) {

                cliente.livroAlugado.add(livro);
                cliente.livrosAntesAlugados.add(livro);
                colecaoLivro.remove(livro);

            }else{
                System.out.println("Não foi possível concluir o aluguel desse livro! ");
            }

        } else {
            System.out.println("Cliente/Livro não encontrado! ");
        }

    }

    public void exibirInformacoesDosLivros(){
        for (Livro l: colecaoLivro) {
            l.imprimirDadosDeLivro();
        }
    }

    public void clienteDevolveLivro(){
        System.out.println("Cpf do cliente? ");
            long cpfCliente = Long.parseLong(scan.nextLine());
        Cliente cliente = encontrarCliente(cpfCliente);

        if (cliente != null){
        System.out.println("Qual livro o cliente deseja devolver?");
            String nomeLivro = scan.nextLine();

            Livro livro = cliente.encontrarLivroAntesAlugado(nomeLivro);
            if (livro != null) {
                if (!cliente.verificarLivrosAntesAlugados(livro)) {
                cliente.livroAlugado.remove(livro);
                cliente.livrosAntesAlugados.remove(livro);
                colecaoLivro.add(livro);
            } else {
                    System.out.println("Esse livro não foi alugado!");
                }
        } else {
                System.out.println("Livro inválido! ");
            }
        }else{
            System.out.println("Cliente não encontrado!");
        }

    }

    public void imprimirDadosClientes(){
        for (Cliente c: listaDeClientes) {
            System.out.println("Nome: " + c.getNome());
            System.out.println("Cpf: " + c.getCpf());
            System.out.println("***************\n");
        }
    }


}


