package com.db.magic;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by Evegeny on 30/08/2017.
 */
@ToString
public class Person {
    private String name;
    private String family;

    public Person(String имя, String фамилия) {
        name = имя;
        family = фамилия;
    }
}

















