package com.codecool.tts.controller;


import com.codecool.tts.service.SaySomethingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class TtsController {

    @Autowired
    private SaySomethingService saySomethingService;


    @PostMapping("/{toSay}")
    public void someThing(@PathVariable(value = "toSay")String toSay){
        saySomethingService.sayString(toSay);

    }

}
