package Model;

public class Clientes{


    private long CPF;

    private String Nome;

    private String Telefone;

    public Clientes(long CPF, String nome, String telefone) {
        this.CPF = CPF;
        Nome = nome;
        Telefone = telefone;
    }

    public long getCPF() {
        return CPF;
    }

    public String getNome() {
        return Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

}
