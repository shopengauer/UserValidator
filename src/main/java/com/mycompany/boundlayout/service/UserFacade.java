/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundlayout.service;

import com.mycompany.boundlayout.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author pavlov
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {
    @PersistenceContext(unitName = "BoundLayout ")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override 
    public void createUser(String userName, String password) {
       
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        em.persist(user);
    }

    @Override
    public boolean validateUser(String userName) {
      TypedQuery<User> tq = em.createNamedQuery("User.findByName", User.class);
       
      return  tq.setParameter("name", userName).getResultList().isEmpty();
    
    }
    
    
    
    
}
