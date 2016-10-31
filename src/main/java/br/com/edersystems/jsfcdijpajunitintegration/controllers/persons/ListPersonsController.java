/*
 *  Project............: JsfCdiJpaJunitIntegration
 *  Developer..........: Éder Luciano da Costa
 *  Copyright..........: 2016
 *  Creation...........: 27/10/2016, 08:15:16
 *  Codification.......: UTF-8 (Utilizado na criação do arquivo)
 *  User...............: Éder
 *  ......................................................................................
 *  Éder Luciano da Costa - © Copyright 2016 - All Rights Reserved.
 *  ......................................................................................
 */
package br.com.edersystems.jsfcdijpajunitintegration.controllers.persons;

import br.com.edersystems.jsfcdijpajunitintegration.model.entities.Person;
import br.com.edersystems.jsfcdijpajunitintegration.model.services.person.PersonService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Administrador
 */
@SuppressWarnings("serial")
public class ListPersonsController implements java.io.Serializable
{
    private static final String PERSON__SAVED__WITH__SUCCESS = "Person Saved With Success!!!";

    @Inject
    private PersonService service;

    private Person person;

    public ListPersonsController()
    {
        this.doCreatePerson();
    }

    public final void doCreatePerson()
    {
        this.person = new Person();
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public String listPersons()
    {
        return "listPersons";
    }

    public List<Person> getPersons()
    {
        return this.service.getPersons();
    }

    public void savePerson()
    {
        this.service.savePerson(this.person);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, PERSON__SAVED__WITH__SUCCESS, PERSON__SAVED__WITH__SUCCESS));
    }

}
