package model;
import java.time.LocalDate;

public class Aluno extends Usuario{

//    Construtor
    public Aluno(String nome, int ID, String tipo) {
        super(nome, ID, tipo);
    }

//    Metodo para calcular a data de devolução para o aluno
    public LocalDate calcularDataFinal(LocalDate dataInicial) {
        return dataInicial.plusDays(15);
    }
}
