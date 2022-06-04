package org.example.repository;


import org.example.dominios.ContaSimples;

import java.util.Collection;

public class ContaRepository implements IRepository<ContaSimples>{

    private Collection<ContaSimples> contasList;



    @Override
    public void save(ContaSimples contaSimples) {
        contasList.add(contaSimples);
    }


    @Override
    public ContaSimples read(ContaSimples contaSimples) {
        if(contasList.contains(contaSimples)){
            return contaSimples;
        }
        return null;
    }
}
