package org.example.dominios;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private Usuario usuario;
    private String nome;
    private ArrayList<Conta> contas;

    public Cliente(Usuario usuario, String nome) {
        this.usuario = usuario;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }


    public void addConta(Conta conta){
        contas.add(conta);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}
