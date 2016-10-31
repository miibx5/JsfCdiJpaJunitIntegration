/*
 *  Projeto.......: JsfCdiJpaJunitIntegration
 *  Developer.....: Éder Luciano da Costa
 *  Copyright.....: 2016
 *  Criação.......: 24/10/2016, 20:32:07
 *  Revisao.......: $Rev:$, $Id:$
 *  Codificacão...: UTF-8 (Utilizado na criação do arquivo)
 *  @author.......: Luciano
 *  .....................................................................................
 *  Éder L. Costa - © Copyright 2016 - All Rights Reserved
 *  .....................................................................................
 */
package br.com.edersystems.jsfcdijpajunitintegration.model.services.person;

import br.com.edersystems.jsfcdijpajunitintegration.model.entities.Person;
import br.com.edersystems.jsfcdijpajunitintegration.model.repositories.person.PersonRepository;
import br.com.edersystems.jsfcdijpajunitintegration.model.repositories.person.PersonRepositoryImpl;
import br.com.edersystems.jsfcdijpajunitintegration.qualifiers.Specific;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Luciano
 */
@RequestScoped
@SuppressWarnings("serial")
public class PersonService implements java.io.Serializable
{
    @Inject
    @Specific(classe = PersonRepositoryImpl.class)
    private PersonRepository repository;

    public Person savePerson(Person p)
    {
        return this.repository.savePojo(p);
    }

    public List<Person> getPersons()
    {
        return this.repository.getALL();
    }
}
