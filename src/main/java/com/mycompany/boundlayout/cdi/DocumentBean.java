/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundlayout.cdi;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author pavlov
 */
@Named(value = "documentBean")
@RequestScoped
public class DocumentBean {

    /**
     * Creates a new instance of DocumentBean
     */
    
    
//    private UploadedFile document;

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }
    
    
    
    public DocumentBean() {
    }
    
}
