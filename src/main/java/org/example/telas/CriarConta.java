package org.example.telas;

import org.example.dominios.Cliente;
import org.example.dominios.Conta;
import org.example.dominios.TipoConta;
import org.example.factory.ContaFactory;
import org.example.repository.ClienteRepository;

import java.util.Objects;
import java.util.Scanner;

public class CriarConta {

    public void executar(Scanner scanner){

        System.out.println("Cliente já cadastrado? \n\t (1) - Sim \n\t (2) - Não ");

        int opcaoExisteCliente = scanner.nextInt();
        if(opcaoExisteCliente>0 && opcaoExisteCliente<=2){
            Cliente cliente = opcaoExisteCliente>1?CriarCliente.executar(scanner):
                    AcessarCliente.execute(scanner);


            System.out.println("Informe a Agência");
            String agencia = scanner.next();
            System.out.println("Informe o tipo de conta");
            StringBuilder builder = new StringBuilder();
            for (TipoConta tipoConta: TipoConta.values()) {
                builder.append(String.format("%s - %s %n", tipoConta.getCode(), tipoConta.getLabel()));
            }
            System.out.println(builder);
            String opcao = scanner.next();
            TipoConta tipoConta = TipoConta.valueOfCode(opcao);
            if(Objects.isNull(tipoConta)){
                System.out.println("Não foi informado o tipo da conta");
            }else{

                Conta minhaConta = ContaFactory.createConta(cliente, tipoConta,agencia);
                if(opcaoExisteCliente>1){
                    ClienteRepository.addCliente(cliente);
                }

                System.out.printf("Cliente %s. %n \t Sua conta %s foi criada com sucesso " +
                                "%n \t Agência: %s %n \t Conta %s %n "
                        , cliente.getNome(),minhaConta.getTipoConta().getLabel(),minhaConta.getAgencia(),minhaConta.getNumeroConta());

            }
        }


    }
}
