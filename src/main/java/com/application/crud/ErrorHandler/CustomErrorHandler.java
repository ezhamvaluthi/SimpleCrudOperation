/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.crud.ErrorHandler;

/**
 *
 * @author EZHAMVALUTH PC
 */
public class CustomErrorHandler {
    
    private String errorMessage;
 
    public CustomErrorHandler(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
}