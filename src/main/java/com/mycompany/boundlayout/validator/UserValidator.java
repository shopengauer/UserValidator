/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundlayout.validator;

import com.mycompany.boundlayout.service.UserFacadeLocal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author pavlov
 */
 
public class UserValidator implements ConstraintValidator<ValidUser, String>{

    
    @EJB
    private UserFacadeLocal userFacade;
    
    @Override
    public void initialize(ValidUser constraintAnnotation) {
          //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        userFacade.validateUser(value);
        return false;
    }

   
    
}
