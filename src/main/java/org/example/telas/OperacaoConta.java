package org.example.telas;

import org.example.dominios.ContaSimples;
import org.example.exception.SaldoInvalidoException;

import java.util.Objects;
import java.util.Scanner;

public class OperacaoConta {
    private ContaSimples contaSimples;
    public OperacaoConta(ContaSimples contaSimples) {
        this.contaSimples = contaSimples;
    }

    public void executar(Scanner scanner) {
        System.out.printf("Conta selecionada %s %n", contaSimples.getNumeroConta());

        int opcao = 0;
        do{
            System.out.println("O que deseja fazer? (0) - Menu Anterior (1) - Saque ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    try {
                        System.out.println("Quanto deseja sacar?");
                        double valor = scanner.nextDouble();
                        if (Objects.nonNull(contaSimples.sacar(valor))) {
                            System.out.println("Sucesso ao realizar o saque");
                        }
                    }catch (SaldoInvalidoException saldoInvalidoException){
                        System.err.println(saldoInvalidoException.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Até a próxima");
            }
        }while(opcao!=0);


    }
}
