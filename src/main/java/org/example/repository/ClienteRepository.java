package org.example.repository;

import org.example.dominios.Cliente;
import org.example.dominios.Usuario;

import java.util.ArrayList;
import java.util.Objects;

public class ClienteRepository {

    private static ArrayList<Cliente> clientesList;

    private ClienteRepository(){

    }

    public static void addCliente(Cliente cliente) {
        if(Objects.isNull(clientesList)) {
            clientesList = new ArrayList<>();
        }
        clientesList.add(cliente);
    }

    public static Cliente findClientePorLoginESenha(String login, String senha) {
        for (Cliente cliente: clientesList) {
            Usuario usuario = cliente.getUsuario();
            if(usuario.autenticar(login,senha)){
                return cliente;
            }
        }
        return null;
    }
}
