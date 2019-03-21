package com.codecool.tts.controller;


import com.codecool.tts.service.SaySomethingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/say")
public class TtsController {

    @Autowired
    private SaySomethingService saySomethingService;

    @GetMapping("/{toSay}")
    public ModelAndView someThing(@PathVariable(value = "toSay")String toSay){
        saySomethingService.sayString(toSay);
        return new ModelAndView("redirect:"+"http://localhost:8001");

    }

}
