/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.crud.repositary;

import com.application.crud.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author EZHAMVALUTH PC
 */
public interface EmployeeRepoisitary extends CrudRepository<Employee, Long>{
    
    Employee findById(long name);
    
    Employee findByName(String name);
    
}
