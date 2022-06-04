package org.example.dominios;

public class Usuario {
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public boolean autenticar(String login, String senha){
        return this.login.equals(login) && this.senha.equals(senha);
    }

}
