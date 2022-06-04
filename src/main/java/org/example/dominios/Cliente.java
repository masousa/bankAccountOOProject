package org.example.dominios;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private Usuario usuario;
    private String nome;
    private ArrayList<ContaSimples> contaSimples;

    public Cliente() {
    }

    public Cliente(Usuario usuario, String nome) {
        this.usuario = usuario;
        this.nome = nome;
        this.contaSimples = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }


    public void addConta(ContaSimples contaSimples) {
        this.contaSimples.add(contaSimples);
    }

    public ArrayList<ContaSimples> getContas() {
        return contaSimples;
    }

    public void setContas(ArrayList<ContaSimples> contaSimples) {
        this.contaSimples = contaSimples;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return usuario.getLogin().equals(cliente.usuario.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario.getLogin());
    }
}
