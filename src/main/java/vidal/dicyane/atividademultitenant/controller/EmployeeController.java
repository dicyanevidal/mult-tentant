package vidal.dicyane.atividademultitenant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vidal.dicyane.atividademultitenant.dao.EmployeeDAO;
import vidal.dicyane.atividademultitenant.model.Employee;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "employeeList")
    public java.util.List<Employee> employeeList(){
        return employeeDAO.findAll();
    }
}
