package com.mycompany.enterprise_application.ejb;

import com.mycompany.enterprise_application.jpa.dao.PersonDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PersonEJB {
    
    @EJB
    private PersonDAO dao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public Long register(String name) {
        return dao.create(name);
    }
    
}
