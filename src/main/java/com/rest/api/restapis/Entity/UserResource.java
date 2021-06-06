package com.rest.api.restapis.Entity;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.rest.api.restapis.userDAOService.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService daoService;

    @GetMapping(path = "allUsers")
    public List<Users> retrieveAllUsers() {
        List<Users> allUsers = this.daoService.findAllUsers();
        if (allUsers == null)
            throw new NoUsersFoundException("");
        return allUsers;
    }

    @GetMapping(path = "getUser/{id}")
    public Users retrieveUser(@PathVariable("id") Integer id) {
        Users user = this.daoService.findOneUser(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);

        // Resource<Users> resource = new Resource<Users>(user);

        // ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        // resource.add(linkTo.withRel("all-users"));
        // return resource;
        return user;
    }

    @PostMapping(path = "/saveUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) {
        Users savedUser = this.daoService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        Users user = this.daoService.deleteOneUser(id);
        if (user == null)
            throw new UserNotFoundException("User with ID:" + id + " Not found");
    }
}
