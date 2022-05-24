package org.example.telas;

import org.example.dominios.Cliente;
import org.example.dominios.Conta;

import java.util.Objects;
import java.util.Scanner;

public class AcessarConta {

    public void execute(Scanner scanner){

        Cliente cliente =  AcessarCliente.execute(scanner);
        if(Objects.nonNull(cliente)){
            for (int i = 0; i < cliente.getContas().size(); i++) {
                Conta conta = cliente.getContas().get(i);
                System.out.printf("%02d - %s - %s/%s %n", (i+1),
                        conta.getTipoConta().getLabel(), conta.getAgencia(), conta.getNumeroConta());
            }
            int opcaoConta = scanner.nextInt();
            if(opcaoConta>0 && opcaoConta<cliente.getContas().size()){
                Conta contaSelecionada = cliente.getContas().get((opcaoConta-1));
                System.out.printf("Conta selecionada %s %n", contaSelecionada.getNumeroConta());
            }else{
                System.out.println("Valor inválido");
            }


        }else{
            System.out.println("Cliente não encontrado");
        }

    }
}
