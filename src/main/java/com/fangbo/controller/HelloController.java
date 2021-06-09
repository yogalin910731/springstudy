package com.fangbo.controller;


import com.fangbo.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person(){
        log.info("方法进来了～");
        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }

    @RequestMapping("/hello")
    public String handle01(){
        return "hello bobo";
    }

}
