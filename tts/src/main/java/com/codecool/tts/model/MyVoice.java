package com.codecool.tts.model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class MyVoice {
    private VoiceManager voiceManager = VoiceManager.getInstance();
    private Voice voice;

    public void saySomething(String toSay){
        this.voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.speak(toSay);
    }

}
