    package model;
    import java.time.LocalDate;

    public class Usuario {
        private String nome;
        private int ID;
        private String tipo;

        public Usuario(String nome, int ID, String tipo){
            this.nome = nome;
            if (ID < 0){
                System.out.println("Não é permitido números negativos.");
            } else { this.ID = ID;}
            this.tipo = tipo;
        }

        public String getNome(){return this.nome;}
        void setNome(String nome){this.nome = nome;}

        public int getID(){return this.ID;}
        void setID(int ID){this.ID = ID;}

        public String getTipo(){return this.tipo;}
        void setTipo(String tipo){this.tipo = tipo;}

        void mostrarUsuario(){
            System.out.println("Nome: " + this.nome);
            System.out.println("ID de usuário: " + this.ID);
            System.out.println("O usuário é um: " + this.tipo);
        }

        public LocalDate calcularDataFinal(LocalDate dataInicial){
            return dataInicial.plusDays(15); // padrão para alunos
        }
}
