import java.util.ArrayList;

public class Cliente {
    private final String nome;
    private final long cpf;
    ArrayList<Livro> livroAlugado = new ArrayList<>();

    ArrayList<Livro> livrosAntesAlugados = new ArrayList<>();
    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }



    public boolean verificarLivrosAntesAlugados(Livro titulo) {
        for (Livro livrosAntesAlugado : livrosAntesAlugados) {
            if (livrosAntesAlugado.equals(titulo)) {
                return false;
            }
        }
        return true;
    }

    public Boolean checarPodeAlugar2(Livro titulo) {
        return (this.livroAlugado.size() < 2) && verificarLivrosAntesAlugados(titulo);
    }

    public Livro encontrarLivroAntesAlugado(String titulo){
        for (Livro livro: livrosAntesAlugados) {
            if (livro.getTitulo().equals(titulo)){
                return livro;
            }
        }
        return null;
    }

}







