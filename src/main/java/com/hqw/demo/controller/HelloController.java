package com.hqw.demo.controller;

import com.hqw.demo.config.DqProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DqProperties dqProperties;

    @RequestMapping(value="/test")
    public String echo(){
        return dqProperties.getName();
    }

    @GetMapping("/test2/{name}/{pwd}")
    public List<?> viewAll(@PathVariable String name, @PathVariable String pwd){

        List<String> list = new ArrayList<>();
        System.out.println("name="+name);
        System.out.println("password="+pwd);

        list.add( name);
        list.add( pwd);

        return list;
    }

}
