package model;

import java.time.LocalDate;


public class Professor  extends Usuario{
    public Professor(String nome, int ID, String tipo){
        super(nome, ID, tipo);
    }

    public LocalDate calcularDataFinal(LocalDate dataInicial) {
        return dataInicial.plusDays(30);
    }
}
