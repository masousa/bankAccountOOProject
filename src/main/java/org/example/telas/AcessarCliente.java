package org.example.telas;

import org.example.dominios.Cliente;
import org.example.repository.ClienteRepository;

import java.util.Scanner;

public class AcessarCliente {

    public static Cliente execute(Scanner scanner){
        System.out.println("Informe o login");
        String login = scanner.next();
        System.out.println("Informe a senha");
        String senha = scanner.next();
        ClienteRepository clienteRepository = new ClienteRepository();
        return clienteRepository.findClientePorLoginESenha(login, senha);

    }
}
