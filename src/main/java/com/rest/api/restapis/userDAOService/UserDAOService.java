package com.rest.api.restapis.userDAOService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rest.api.restapis.Entity.Users;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

    private static List<Users> users = new ArrayList<>();
    private static int idCount = 3;
    static {
        users.add(new Users(1, "Vishal Sharma", new Date()));
        users.add(new Users(2, "Ankit Sharma", new Date()));
        users.add(new Users(3, "Yo Yo Honey Singh", new Date()));
    }

    public List<Users> findAllUsers() {
        return users;
    }

    public Users saveUser(Users user) {
        if (user.getId() == null) {
            user.setId(++idCount);
        }
        users.add(user);

        return user; 
    }

    public Users findOneUser(Integer id) {
        for(Users user: users) {
            if(user.getId() == id)
            return user;
        }
        return null;
    }

    public Users deleteOneUser(Integer id) {
        for(Users user : users) {
            if(user.getId() == id) {
                users.remove(user);
                return user;
            }
        }
        return null;
    }
}
