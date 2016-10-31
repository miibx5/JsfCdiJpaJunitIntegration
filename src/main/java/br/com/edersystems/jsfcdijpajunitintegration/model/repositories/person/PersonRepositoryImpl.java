/*
 *  Projeto.......: JsfCdiJpaJunitIntegration
 *  Developer.....: Éder Luciano da Costa
 *  Copyright.....: 2016
 *  Criação.......: 24/10/2016, 20:26:59
 *  Revisao.......: $Rev:$, $Id:$
 *  Codificacão...: UTF-8 (Utilizado na criação do arquivo)
 *  @author.......: Luciano
 *  .....................................................................................
 *  Éder L. Costa - © Copyright 2016 - All Rights Reserved
 *  .....................................................................................
 */
package br.com.edersystems.jsfcdijpajunitintegration.model.repositories.person;

import br.com.edersystems.jsfcdijpajunitintegration.base.repository.GenericRepositoryImpl;
import br.com.edersystems.jsfcdijpajunitintegration.model.entities.Person;
import br.com.edersystems.jsfcdijpajunitintegration.qualifiers.Specific;
import javax.enterprise.context.RequestScoped;

@SuppressWarnings("serial")
@Specific(classe = PersonRepositoryImpl.class)
@RequestScoped
public class PersonRepositoryImpl extends GenericRepositoryImpl<Person> implements PersonRepository
{
    public PersonRepositoryImpl()
    {
        super(Person.class);
    }
}
