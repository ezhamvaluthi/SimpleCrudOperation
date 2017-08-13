/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.crud.controller;

import com.application.crud.ErrorHandler.CustomErrorHandler;
import com.application.crud.model.Employee;
import com.application.crud.repositary.EmployeeRepoisitary;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EZHAMVALUTH PC
 */
@RestController
public class RequestController {
    
    @Autowired
    EmployeeRepoisitary employeeRepoisitary;


    @RequestMapping(value = "/createEmployee",method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepoisitary.save(employee);
    }
    
    
     @RequestMapping(value = "/updateEmployee",method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employe = employeeRepoisitary.findById(employee.getId());
        if (employe == null) {  
            return new ResponseEntity(new CustomErrorHandler("Unable to upate. Employee with id " + employe.getId() + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employeeRepoisitary.save(employee));
    }
    
    
    @RequestMapping(value = "/deleteEmployee/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepoisitary.findById(id);
        if (employee == null) {
            return new ResponseEntity(new CustomErrorHandler("Unable to delete. Employee with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        employeeRepoisitary.delete(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/getEmployee/{empName}",method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable String name){
        return employeeRepoisitary.findByName(name);
    }
    
    @RequestMapping(value = "/getEmployee",method = RequestMethod.GET)
    public List<Employee> getEmployee(){
        return (List)employeeRepoisitary.findAll();
    }
    
}
