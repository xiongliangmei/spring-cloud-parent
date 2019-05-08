package com.xl.controller;

import com.xl.service.SchedualServieHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    SchedualServieHi schedualServieHi;

    @GetMapping(value = "/hi")
    public String  sayHi(){
        return schedualServieHi.syaHi();
    }
}
