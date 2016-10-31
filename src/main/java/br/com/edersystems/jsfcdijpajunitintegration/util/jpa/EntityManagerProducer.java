/*
 *  Projeto.......: JsfCdiJpaJunitIntegration
 *  Developer.....: Éder Luciano da Costa
 *  Copyright.....: 2016
 *  Criação.......: 24/10/2016, 19:58:24
 *  Revisao.......: $Rev:$, $Id:$
 *  Codificacão...: UTF-8 (Utilizado na criação do arquivo)
 *  @author.......: Luciano
 *  .....................................................................................
 *  Éder L. Costa - © Copyright 2016 - All Rights Reserved
 *  .....................................................................................
 */
package br.com.edersystems.jsfcdijpajunitintegration.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luciano
 */
@ApplicationScoped
public class EntityManagerProducer
{
    private final EntityManagerFactory factory;

    public EntityManagerProducer()
    {
        factory = Persistence.createEntityManagerFactory("jsfCdiPU");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager()
    {
        return factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager)
    {
        manager.close();
    }
}
