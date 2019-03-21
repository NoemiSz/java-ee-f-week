package com.codecool.tts;

import com.codecool.tts.model.MyVoice;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtsApplication.class, args);
    }

    @Bean
    MyVoice myvoice() { return new MyVoice();}

    @Bean
    VoiceManager voiceManager(){ return VoiceManager.getInstance();}


}
