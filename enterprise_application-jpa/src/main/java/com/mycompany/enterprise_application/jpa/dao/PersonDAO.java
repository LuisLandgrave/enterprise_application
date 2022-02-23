package com.mycompany.enterprise_application.jpa.dao;

import com.mycompany.enterprise_application.jpa.entities.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDAO {

    @PersistenceContext
    private EntityManager em;

    public Long create(String name) {
        return create(new Person(name));
    }

    public Long create(Person person) {

        em.persist(person);

        return person.getId();

    }

}
