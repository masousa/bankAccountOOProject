package org.example.telas;

import org.example.dominios.Cliente;
import org.example.dominios.ContaSimples;

import java.util.Objects;
import java.util.Scanner;

public class AcessarConta {

    public void execute(Scanner scanner){

        Cliente cliente =  AcessarCliente.execute(scanner);
        if(Objects.nonNull(cliente)){
            for (int i = 0; i < cliente.getContas().size(); i++) {
                ContaSimples contaSimples = cliente.getContas().get(i);
                System.out.printf("%02d - %s - %s/%s %n", (i+1),
                        contaSimples.getTipoConta().getLabel(), contaSimples.getAgencia(), contaSimples.getNumeroConta());
            }
            int opcaoConta = scanner.nextInt();
            if(opcaoConta>0 && opcaoConta<=cliente.getContas().size()){
                ContaSimples contaSimplesSelecionada = cliente.getContas().get((opcaoConta-1));
                OperacaoConta operacaoConta = new OperacaoConta(contaSimplesSelecionada);
               operacaoConta.executar(scanner);
            }else{
                System.out.println("Valor inválido");
            }


        }else{
            System.out.println("Cliente não encontrado");
        }

    }
}
