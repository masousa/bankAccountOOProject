package org.example.telas;

import org.example.dominios.Cliente;
import org.example.dominios.Usuario;

import java.util.Scanner;

public class CriarCliente {

    public static Cliente executar(Scanner scanner){
        System.out.println("Criando um cliente ");
        System.out.println("Informe seu nome ");
        String nome = scanner.next();

        System.out.println("Informe o login de acesso ");
        String login = scanner.next();
        System.out.println("Informe a senha de acesso ");
        String senha = scanner.next();
        System.out.println("Informe novamente a senha de acesso ");
        String senhaConfirmada = scanner.next();
        if(senha.equals(senhaConfirmada)){
            return new Cliente(new Usuario(login,senha),nome);
        }
        System.out.println("As senhas não conferem. Tente o cadastro novamente");

        return CriarCliente.executar(scanner);

    }
}
