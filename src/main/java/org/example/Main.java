package org.example;

import org.example.telas.CriarConta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao banco 000");

        System.out.println("O que desejas fazer hoje?");

        int opcao = 0;
        do{
            System.out.println(" 01 - Criar uma nova conta \n 02 - Acessar minha conta \n 03 - Sair");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    CriarConta criarConta = new CriarConta();
                    criarConta.executar(scanner);

                    break;
                default:
                    System.out.println("Opcao errada");
            }


        }while(opcao!=3);
    }
}
