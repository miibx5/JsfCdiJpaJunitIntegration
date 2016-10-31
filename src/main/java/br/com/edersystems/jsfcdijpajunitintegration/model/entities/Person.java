/*
 *  Projeto.......: JsfCdiJpaJunitIntegration
 *  Developer.....: Éder Luciano da Costa
 *  Copyright.....: 2016
 *  Criação.......: 24/10/2016, 20:20:56
 *  Revisao.......: $Rev:$, $Id:$
 *  Codificacão...: UTF-8 (Utilizado na criação do arquivo)
 *  @author.......: Luciano
 *  .....................................................................................
 *  Éder L. Costa - © Copyright 2016 - All Rights Reserved
 *  .....................................................................................
 */
package br.com.edersystems.jsfcdijpajunitintegration.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Luciano
 */
@Entity
@Table(name = "persons")
@SuppressWarnings("serial")
public class Person implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, name = "registration_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Column(nullable = false, name = "date_of_birth")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;

    public Person()
    {
        this(null, null, null);
    }

    public Person(Long id, String name, Date dateOfBirth)
    {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = new Date();
        this.active = true;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof Person))
        {
            return false;
        }
        Person other = (Person)object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString()
    {
        return "br.com.edersystems.jsfcdijpajunitintegration.model.entities.Person[ id=" + id + " ]";
    }

}
