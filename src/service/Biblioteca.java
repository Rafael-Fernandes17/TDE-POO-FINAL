package service;
import java.time.LocalDate;import java.util.ArrayList;import model.*;

public class Biblioteca {
    private String nomeBiblioteca;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

//    Construtor
    public Biblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
        for (Usuario u: usuarios){
            if (u.getTipo().equals("Professor")){
                Professor professor = (Professor) u;
            }
            Aluno aluno = (Aluno) u;
        }
    }

//    Getters e Setters
    public String getNome(){return this.nomeBiblioteca;}
    public void setNome(String nome){this.nomeBiblioteca = nome;}

    public ArrayList<Emprestimo> getEmprestimos(){return this.emprestimos;}
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos){this.emprestimos = emprestimos;}

    public ArrayList<Livro> getLivros(){return this.livros;}
    public void setUsuarios(ArrayList<Livro> livros){this.livros = livros;}

    public ArrayList<Usuario> getUsuarios(){return this.usuarios;}
    public void setNome(ArrayList<Usuario> usuarios){this.usuarios = usuarios;}

//    Métodos de funções
    public void listarLivros() {
        System.out.println("Nossos títulos presentes nessa biblioteca são: ");
        for(int i = 0; i < livros.size(); i++){
            System.out.println((i + 1)+ ". " + livros.get(i).getTitulo());
        }
        System.out.println();
    }

    public void adicionarLivro(Livro livro){
        for (Livro l: livros){
            if(l.getISBN() == livro.getISBN()){
                System.out.println("Não é possível adicionar esse livro pois já existe um outro com esse mesmo ISBN");
                System.out.println();
                return;
            }
        }
        System.out.println("Livro " + livro.getTitulo() + " adicionado com sucesso!");
        System.out.println();
        livros.add(livro);
    }

    public void removerLivro(Livro livro){
        if(livros.contains(livro)){
            livros.remove(livro);
            System.out.println("Livro removido da " + this.nomeBiblioteca + " com sucesso");
            System.out.println();
        }
    }

    public Livro buscarLivro(String tituloLivro) {
        for (Livro l: livros){
            if (l.getTitulo().equals(tituloLivro)){
                System.out.println("O título " + l.getTitulo() + " existe em nossa biblioteca.");
                System.out.println();
                return l;
            }
        }
        System.out.println("Não foi possível encontrar o livro que você procura");
        System.out.println();
        return null;
    }

    public void emprestarLivro(Livro livro, Usuario usuario, int dia, int mes, int ano){
        System.out.println("Usuário tentando emprestar um livro...");
        if(livro.getQuantidade() > 0){
            Emprestimo emprestimoNovo = new Emprestimo(livro, usuario, dia, mes, ano);
            emprestimos.add(emprestimoNovo);
            livro.setQuantidadeDisponivel(livro.getQuantidade() - 1);
            System.out.println("Livro emprestado com sucesso!");
            System.out.println();
            return;
        }
        System.out.println("Todos os livros deste título já foram emprestados, aguarde ficar disponível ou escolha outro título");
        System.out.println();
    }

    public void devolverLivro(Livro livro){
        System.out.println("Devolvendo livro...");
        if (!livros.contains(livro)) {
            System.out.println("Esse livro não pertence à essa biblioteca!");
            System.out.println();
            return;
        } else {
        for(Emprestimo e: emprestimos){
            if(e.getLivro().equals(livro)){
                if (e.getDataFinal().isAfter(LocalDate.now())){
                livro.setQuantidadeDisponivel(livro.getQuantidade() + 1);
                System.out.println("Livro devolvido com seucesso");
                System.out.println();
                return;}
                System.out.println("O livro só pode ser devolvido após o pagamento da multa por extrapolar a data");
                System.out.println();
                }
            }
        }
    }

    public void exibirHistorico(Usuario usuario) {
        boolean encontrou = false;

        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(usuario)) {
                e.mostrarEmprestimo();
                System.out.println();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Esse usuário não efetuou nenhum empréstimo.");
            System.out.println();
        }
    }

    public void emprestimosAtivos(){
        for(Emprestimo e: emprestimos){
            if(e.dataFinal.isAfter(LocalDate.now()) && e.dataInicial.isBefore(LocalDate.now())){
                 e.mostrarEmprestimo();
                System.out.println("Estado do emprestimo: ativo");
                System.out.println();
            }
        }
    }
}




