package com.db.validation_example;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Evegeny on 01/09/2017.
 */
@AllArgsConstructor
@Data
public class Employee {
    @NotNull
    private String name;
    @Min(value = 12,message = "да тебя по суд надо!!!")
    private int age;

}
