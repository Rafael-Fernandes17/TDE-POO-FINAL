package model;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private int ISBN;
    private int quantidadeDisponivel;

//    Construtor
    public Livro(String titulo, String autor, int ano, int ISBN, int quantidadeDisponivel){
        this.titulo = titulo;
        this.autor = autor;
        if (ISBN < 0 || ano < 0){
            System.out.println("Não é permitido números negativos.");
            return;
        } else { this.ISBN = ISBN; this.ano = ano;}

        if(quantidadeDisponivel > 0){
            this.quantidadeDisponivel = quantidadeDisponivel;
        } else { System.out.println("Deve existir ao menos 1 livro para ser adicionado a biblioteca futuramente.");}
    }

//    Getter e setters
    public String getTitulo(){return this.titulo;}
    void setTitulo(String titulo){this.titulo = titulo;}

    public String getAutor(){return this.autor;}
    void setAutor(String autor){this.autor = autor;}

    public int getAno(){return this.ano;}
    void setAno(int ano){this.ano = ano;}

    public int getISBN(){return this.ISBN;}
    void setISBN(int ISBN){ this.ISBN = ISBN;}

    public int getQuantidade(){return this.quantidadeDisponivel;}
    public void setQuantidadeDisponivel(int quantidadeDisponivel){this.quantidadeDisponivel = quantidadeDisponivel;}

//    Metodo para exibir valores
    void mostrarLivro(){
        System.out.println("O título do livro é: " + this.titulo);
        System.out.println("O autor do livro é: " + this.autor);
        System.out.println("O ano de lançamento do livro é: " + this.ano);
        System.out.println("O ISBN do livro é: " + this.ISBN);
        System.out.println("A quantidade dísponível desse livro é: " + this.quantidadeDisponivel);
    }
}
