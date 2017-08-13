package com.application.crud;

import com.application.crud.controller.RequestController;
import com.application.crud.model.Employee;
import com.application.crud.repositary.EmployeeRepoisitary;
import java.util.ArrayList;
import java.util.List;
import mockit.Deencapsulation;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrudApplicationTests {
    
        @mockit.Tested
        RequestController requestController;
        
        @mockit.Mocked
        EmployeeRepoisitary employeeRepoisitary;

	@Test
        public void testCreateRestController(){
            Employee emp = new Employee();
            emp.setAge(25);
            new Expectations() {{
                employeeRepoisitary.save(emp);
                result = emp;
            }};
            Deencapsulation.setField(requestController, "employeeRepoisitary", employeeRepoisitary);
            Employee emp1 = requestController.createEmployee(emp);
            Assert.assertEquals(emp.getAge(),emp1.getAge());
        }
        
        @Test
        public void testGetEmployee(){
            List<Employee> list = new ArrayList<>();
            Employee emp = new Employee();
            emp.setAge(25);
            list.add(emp);
            new Expectations() {{
                employeeRepoisitary.findAll();
                result = list;
            }};
            Deencapsulation.setField(requestController, "employeeRepoisitary", employeeRepoisitary);
            List<Employee> emp1 = requestController.getEmployee();
            Assert.assertEquals(list.size(),emp1.size());
        }

}
