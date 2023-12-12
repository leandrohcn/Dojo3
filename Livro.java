public class Livro {
    private final String titulo;
    private final String autor;
    private final String editora;
    private final String dataPublicacao;

    public Livro(String titulo, String autor, String editora, String dataPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;

    }

    public String getTitulo() {
        return titulo;
    }

    public void imprimirDadosDeLivro(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editora: " + this.editora);
        System.out.println("Data de publicação: " + this.dataPublicacao);
        System.out.println("*****************\n");
    }

}
