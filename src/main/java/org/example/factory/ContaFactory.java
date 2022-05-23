package org.example.factory;

import org.example.dominios.Cliente;
import org.example.dominios.Conta;
import org.example.dominios.TipoConta;

import java.util.Random;

public class ContaFactory {

    public static Conta createConta(Cliente cliente, TipoConta tipoConta, String agencia){
        String numeroConta = String.format("%04d", new Random().nextInt());

        Conta conta = new Conta(numeroConta, agencia, tipoConta);

        cliente.addConta(conta);
        return conta;
    }
}
