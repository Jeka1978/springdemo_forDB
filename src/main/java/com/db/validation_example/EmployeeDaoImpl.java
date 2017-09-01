package com.db.validation_example;

import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("employee = " + employee+" was saved");
    }
}
