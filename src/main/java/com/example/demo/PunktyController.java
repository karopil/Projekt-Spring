package com.example.demo;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class PunktyController {

    CopyOnWriteArrayList<String> users = new CopyOnWriteArrayList<String>(Arrays.asList("s1", "s2", "s3"));

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<String> getUsers()
    {
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    List<String> addUser(@RequestBody String name)
    {
        if(name != null) users.add(name );
        return users;
    }
}
