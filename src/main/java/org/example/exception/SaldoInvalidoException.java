package org.example.exception;

public class SaldoInvalidoException extends Exception {
    public SaldoInvalidoException(){
        super("Não existe saldo para esta conta");
    }

    public SaldoInvalidoException(String message){
        super(message);
    }
}
