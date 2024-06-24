package Model;

import java.util.ArrayList;

public class Vendedores {

    private int idVendedores;

    private String Nome;


    public Vendedores(int id, String nome) {
        this.idVendedores = id;
        this.Nome = nome;
    }

    public Vendedores(){}

    public int getId() {
        return idVendedores;
    }

    public String getNome() {
        return Nome;
    }



}
