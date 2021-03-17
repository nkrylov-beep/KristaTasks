package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Driver {
    public Integer id;
    public String name;
    public Integer salary;

    public Driver() {
    }

    public Driver(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        return Checker.isEquals(obj, this);
    }
}
