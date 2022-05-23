package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    private String nome;


    public static void main( String[] args )
    {
        App objectApp = new App();
        objectApp.setNome("teste");
        System.out.println(objectApp.nome);
    }

    private String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
}
