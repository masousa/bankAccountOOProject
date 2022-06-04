package org.example.dominios;

public enum TipoTransacao {
    DEBITO("Débito"), CREDITO("Crédito");
    private String label;
    private TipoTransacao(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
