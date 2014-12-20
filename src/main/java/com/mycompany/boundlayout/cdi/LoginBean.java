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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
    private String password1;
    
    @NotBlank
    private String password2;
    
   
    public void validatePassword(ActionEvent event){
        
        if(!(password1.equals(password2))){
           
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("Passwords not equals");
            facesContext.addMessage("inputPas1", facesMessage);
           
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/index");
            
        }
        
    }    
    
    
    
    
    public String createUser(){
        
      if(password1.equals(password2)) { 
         userFacade.createUser(userName, password1);
      }
         return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password) {
        this.password1 = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
     
    
     
}
