package org.example.dominios;

public enum TipoConta {
    CORRENTE("Corrente", "01"), POUPANCA("Poupança", "02"), SALARIO("Salário", "03");
    private String label;
    private String code;

    private TipoConta(String label, String code){
        this.label = label;
        this.code = code;
    }

    public static TipoConta valueOfCode(String opcao) {
        for (TipoConta tipoConta: TipoConta.values()) {
            if(tipoConta.getCode().equals(opcao)){
                return tipoConta;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
