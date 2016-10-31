/*
 *  Projeto.......: JsfCdiJpaJunitIntegration
 *  Developer.....: Éder Luciano da Costa
 *  Copyright.....: 2016
 *  Criação.......: 24/10/2016, 19:38:20
 *  Revisao.......: $Rev:$, $Id:$
 *  Codificacão...: UTF-8 (Utilizado na criação do arquivo)
 *  @author.......: Luciano
 *  .....................................................................................
 *  Éder L. Costa - © Copyright 2016 - All Rights Reserved
 *  .....................................................................................
 */
package br.com.edersystems.jsfcdijpajunitintegration.base.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Luciano
 * @param <E>
 */
public interface GenericRepository<E> extends java.io.Serializable
{
    /**
     * Persist the newInstance object into database
     *
     * @param classToSave
     * @return
     */
    E savePojo(E classToSave);

    /**
     * Retrieve an object that was previously persisted to the database using the indicated id as primary key
     *
     * @param id
     * @return
     */
    E getPojoByPrimaryKey(Serializable id);

    /**
     *
     *
     * @param query
     * @param values
     * @return
     */
    E getPojo(String query, Object... values);

    /**
     * Save changes made to a persistent object.
     *
     * @param classToUpdate
     * @return
     */
    E updatePojo(E classToUpdate);

    /**
     * Remove an object from persistent storage in the database
     *
     * @param id
     */
    void removePojo(Serializable id);

    /**
     *
     * @return
     */
    List<E> getALL();

    /**
     *
     * @param query
     * @param values
     * @return
     */
    List<E> getList(String query, Object... values);

}
