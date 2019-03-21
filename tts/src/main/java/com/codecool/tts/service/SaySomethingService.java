package com.codecool.tts.service;

import com.codecool.tts.model.MyVoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SaySomethingService {



    @Autowired
    private MyVoice myVoice;

    public void sayString(String toSay){
        myVoice.saySomething(toSay);

    }



}
