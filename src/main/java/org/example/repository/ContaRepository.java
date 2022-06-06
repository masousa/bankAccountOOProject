package org.example.repository;


import org.example.dominios.IContaSimples;

import java.util.Collection;

public class ContaRepository extends LocalFileRepository<IContaSimples> implements IRepository<IContaSimples> {

    public ContaRepository() {
        super("contas.txt");
    }

    public Collection<IContaSimples> findAll() {
        return super.persistenceList;
    }
}
