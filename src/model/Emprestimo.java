package model;
import java.time.*;import java.time.format.DateTimeFormatter;import java.util.Scanner;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private int dia;
    private int mes;
    private int ano;
    public LocalDate dataInicial;
    public LocalDate dataFinal;

//    Construtor
public Emprestimo(Livro livro, Usuario usuario, int dia, int mes, int ano) {
    Scanner input = new Scanner(System.in);

    this.livro = livro;
    this.usuario = usuario;
    this.dataInicial = LocalDate.of(ano, mes, dia);
    if (dataInicial.isAfter(LocalDate.now())) {
        while (dataInicial.isAfter(LocalDate.now())) {
            System.out.println("A data inserida está inválida. Insira uma data que não seja maior que hoje!");
            System.out.println("Insira um novo dia: ");
            int diaNovo = input.nextInt();
            System.out.println("Insira um novo mes: ");
            int mesNovo = input.nextInt();
            System.out.println("Insira um novo ano: ");
            int anoNovo = input.nextInt();
            dataInicial = LocalDate.of(anoNovo, mesNovo, diaNovo);}
    }
    this.dataFinal = usuario.calcularDataFinal(dataInicial);
}

//Getters e Setters
    public Livro getLivro(){return this.livro;}
    void setLivro(Livro livro){this.livro = livro;}

    public Usuario getUsuario(){return this.usuario;}
    void setUsuario(Usuario usuario){this.usuario = usuario;}


    public int getDia(){return this.dia;}
    public void setDia(int dia){this.dia = dia;}

    public int getMes() {return mes;}
    public void setMes(int mes) {this.mes = mes;}

    public int getAno() {return ano;}
    public void setAno(int ano) {this.ano = ano;}

    LocalDate getDataInicio(){return dataInicial;}
    void setDataInicio(LocalDate dataInicial){this.dataInicial = dataInicial;}

    public LocalDate getDataFinal(){return dataFinal;}
    public void setDataFinal(LocalDate dataFinal){this.dataFinal = dataFinal;}

//    Metodo para exibir valores
    public void mostrarEmprestimo(){
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("O livro emprestado foi: " + livro.getTitulo());
        System.out.println("O usuário que emprestou o livro foi: " + usuario.getNome());
        System.out.println("Esse emprestimo iniciou dia: " + dataInicial.format(formatoBrasileiro));
        if(this.dataFinal.isAfter(LocalDate.now())){
            System.out.println("Esse emprestimo finalizará dia: " + dataFinal.format(formatoBrasileiro));
        return;}
        System.out.println("O emprestímo deste livro finalizou dia: " + dataFinal.format(formatoBrasileiro));
    }
}
