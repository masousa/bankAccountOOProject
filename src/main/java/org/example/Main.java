package org.example;

import org.example.dominios.Cliente;
import org.example.dominios.Usuario;
import org.example.repository.ClienteRepository;
import org.example.telas.AcessarConta;
import org.example.telas.CriarConta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteRepository repository = new ClienteRepository();
        repository.save(new Cliente(new Usuario("loginDeVergonha", "123"), "nome qualquer"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao banco 000");

        System.out.println("O que desejas fazer hoje?");

        int opcao = 0;
        do {
            System.out.println(" 01 - Criar uma nova conta \n 02 - Acessar minha conta \n 03 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    CriarConta criarConta = new CriarConta();
                    criarConta.executar(scanner);
                    break;
                case 2:
                    AcessarConta acessarConta = new AcessarConta();
                    acessarConta.execute(scanner);

                    break;
                default:
                    System.out.println("Opcao errada");
            }


        }while(opcao!=3);
    }
}
