package com.rest.api.restapis.Entity;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Users {

    private Integer id;

    @Size(min = 2 ,message = "Name must be grater than 2 characters")
    private String name;

    @Past(message = "BirthDate should be past")
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users [birthDate=" + birthDate + ", id=" + id + ", name=" + name + "]";
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Users(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.birthDate = date;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
