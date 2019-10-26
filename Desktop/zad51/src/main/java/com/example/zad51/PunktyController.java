package com.example.zad51;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    private List<String> user;

    public PunktyController(){
        this.user=new CopyOnWriteArrayList<>();
        user.addAll(Arrays.asList("Michał Zapart","Jan Nowak","Marian Nowak"));
    }

    @RequestMapping(value = "/users", method= RequestMethod.GET)
    public List<String> getUser(){
        return user;
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public int addingUser(@RequestBody String ownUser){
        user.add(ownUser);
        return user.size();
    }
}
