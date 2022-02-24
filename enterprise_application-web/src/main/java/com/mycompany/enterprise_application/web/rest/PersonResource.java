package com.mycompany.enterprise_application.web.rest;

import com.mycompany.enterprise_application.ejb.PersonService;
import com.mycompany.enterprise_application.jpa.entities.Person;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/person")
public class PersonResource {

    @Inject
    private PersonService personService;

    /**
     * Retrieves representation of an instance of
     * com.mycompany.enterprise_application.web.rest.PersonResource
     *
     * @return an instance of
     * com.mycompany.enterprise_application.jpa.entities.Person
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return new Person("name");
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person find(@PathParam("id") String id) {
        System.out.println("com.mycompany.enterprise_application.web.rest.PersonResource.find()");
        System.out.println("id=" + id);
        return personService.read(UUID.fromString(id));
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Person content) {
        throw new UnsupportedOperationException();
    }

}
