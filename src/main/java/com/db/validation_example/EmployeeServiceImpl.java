package com.db.validation_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private Validator validator;

    @Autowired
    private EmployeeDao dao;

    @Override
    public void handleEmployee(Employee employee) {
        Set<ConstraintViolation<Employee>> set = validator.validate(employee);
        if (set.isEmpty()) {
            dao.saveEmployee(employee);
        }else {
            for (ConstraintViolation<Employee> employeeConstraintViolation : set) {
                System.out.println(employeeConstraintViolation.getMessage());
            }
            throw new IllegalStateException("not valid");
        }
    }
}
