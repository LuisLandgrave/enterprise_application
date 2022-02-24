package com.mycompany.enterprise_application.jpa.repositories;

import com.mycompany.enterprise_application.jpa.entities.Person;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public UUID create(String name) {
        return create(new Person(name));
    }

    public UUID create(Person person) {

        em.persist(person);

        return person.getId();

    }

    public Person read(UUID id) {
        return em.find(Person.class, id);
    }

    public void update(Person person) {
        em.merge(person);

    }

    public void delete(Person person) {
        em.remove(person);
    }

}
