package app;
import service.Biblioteca;import model.Livro;import model.Professor; import model.Aluno;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        Criando service.Biblioteca
        Biblioteca BibliotecaPuc = new Biblioteca("service.Biblioteca PUC");

//        Criando Livros
        Livro l1 = new Livro("Percy Jackson e o Ladrão de Raios", "Rick Riordan", 2005, 1, 1);
        Livro l2 = new Livro("Percy Jackson e o Mar de Monstros", "Rick Riordan", 2006, 2, 4);
        Livro l3 = new Livro("Percy Jackson e a Maldição do Titã", "Rick Riordan", 2007, 3, 6);
        Livro l4 = new Livro("Percy Jackson e a Batalha do Labirinto", "Rick Riordan", 2008, 3, 6);

//       Criando Usuarios
        Aluno u1 = new Aluno("Rafael", 1, "Aluno");
        Aluno u2 = new Aluno("Abner", 2, "Aluno");
        Professor u3 = new Professor("Matheus", 3, "Professor");

//       Adicionando livros a biblioteca
        System.out.println("Adicionando Livros:  ");
        BibliotecaPuc.adicionarLivro(l1);
        BibliotecaPuc.adicionarLivro(l2);
        BibliotecaPuc.adicionarLivro(l3);
        BibliotecaPuc.adicionarLivro(l4);

//        Listando livros da biblioteca
        System.out.println("Lista de livros: ");
        BibliotecaPuc.listarLivros();

//        Emprestando livros
        BibliotecaPuc.emprestarLivro(l1, u2, 4, 5, 2007);

//        Exemplo de livro que vai dar errado o emprestimo
        BibliotecaPuc.emprestarLivro(l1, u2, 4, 8, 2007);
        BibliotecaPuc.emprestarLivro(l3, u3, 10, 9, 2025);
        BibliotecaPuc.emprestarLivro(l2, u3, 4, 8, 2024);

//        Exibindo histórico de emprestimos dos usuarios
        System.out.println("Exibindo Históricos: ");
        BibliotecaPuc.exibirHistorico(u3);
        BibliotecaPuc.exibirHistorico(u1);

//        Devolvendo livro
        BibliotecaPuc.devolverLivro(l2);

//      Buscando Livro
        BibliotecaPuc.buscarLivro("Percy Jackson e a Maldição do Titã");

//        Verificando emprestimos ativos
        BibliotecaPuc.emprestimosAtivos();

//        removendo livro
        BibliotecaPuc.removerLivro(l4);
    }
}