package com.codecool.tts.model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import org.springframework.beans.factory.annotation.Autowired;

public class MyVoice {

    @Autowired
    VoiceManager voiceManager;
    Voice voice;


    public void saySomething(String toSay){
        this.voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.setRate(130);
        voice.setPitch(150);
        voice.setVolume(3);
        voice.speak(toSay);
        voice.deallocate();

    }

}
