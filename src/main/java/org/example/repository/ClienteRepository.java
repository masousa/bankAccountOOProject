package org.example.repository;

import org.example.dominios.Cliente;
import org.example.dominios.Usuario;

public class ClienteRepository extends LocalFileRepository<Cliente> implements IRepository<Cliente> {


    public ClienteRepository() {
        super("clientes.txt");

    }

    public Cliente findClientePorLoginESenha(String login, String senha) {
        for (Cliente cliente : persistenceList) {
            Usuario usuario = cliente.getUsuario();
            if (usuario.autenticar(login, senha)) {
                return cliente;
            }
        }
        return null;
    }





}
