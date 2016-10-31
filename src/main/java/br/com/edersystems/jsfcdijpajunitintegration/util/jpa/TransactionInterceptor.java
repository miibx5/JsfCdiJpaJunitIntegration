/*
 *  Projeto.......: JsfCdiJpaJunitIntegration
 *  Developer.....: Éder Luciano da Costa
 *  Copyright.....: 2016
 *  Criação.......: 24/10/2016, 19:57:11
 *  Revisao.......: $Rev:$, $Id:$
 *  Codificacão...: UTF-8 (Utilizado na criação do arquivo)
 *  @author.......: Luciano
 *  .....................................................................................
 *  Éder L. Costa - © Copyright 2016 - All Rights Reserved
 *  .....................................................................................
 */
package br.com.edersystems.jsfcdijpajunitintegration.util.jpa;

import br.com.edersystems.jsfcdijpajunitintegration.util.jpa.annotations.Transactional;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Luciano
 */
@Interceptor
@Transactional
public class TransactionInterceptor
{
    @Inject
    private EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception
    {
        EntityTransaction trx = manager.getTransaction();
        boolean criador = false;

        try
        {
            if(!trx.isActive())
            {
                // truque para fazer rollback no que já passou
                // (senão, um futuro commit, confirmaria até mesmo operações sem transação)
                trx.begin();
                trx.rollback();

                // agora sim inicia a transação
                trx.begin();

                criador = true;
            }

            return context.proceed();
        }
        catch(Exception e)
        {
            if(trx != null && criador)
            {
                trx.rollback();
            }

            throw e;
        }
        finally
        {
            if(trx != null && trx.isActive() && criador)
            {
                trx.commit();
            }
        }
    }
}
