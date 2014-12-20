/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundlayout.cdi;

import com.mycompany.boundlayout.service.UserFacadeLocal;
import com.mycompany.boundlayout.validator.ValidUser;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author pavlov
 */
@Named(value = "login")
@RequestScoped
public class LoginBean {

    /**
     * Creates a new instance of IndexBean
     */
    
    @EJB
    private UserFacadeLocal userFacade;
    
    
    public LoginBean() {
    }
    
    @ValidUser
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
    
    
    public String createUser(){
        
         userFacade.createUser(userName, password);
         return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
    public String getValidateValue() {
        return userName;
    }

    public void setValidateValue(String userName) {
        this.userName = userName;
    }
    
}
