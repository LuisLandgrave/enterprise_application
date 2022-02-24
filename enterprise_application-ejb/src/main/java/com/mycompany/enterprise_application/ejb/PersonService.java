package com.mycompany.enterprise_application.ejb;

import com.mycompany.enterprise_application.jpa.entities.Person;
import com.mycompany.enterprise_application.jpa.repositories.PersonRepository;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PersonService {

    @EJB
    private PersonRepository personRepository;

    public UUID create(String name) {
        return personRepository.create(name);
    }

    public Person read(UUID id) {
        return personRepository.read(id);
    }

    public void update(UUID id, String name) {

        Person person = personRepository.read(id);
        person.setName(name);

        personRepository.update(person);

    }

    public void delete(UUID id) {

        Person person = personRepository.read(id);

        personRepository.delete(person);

    }

}
