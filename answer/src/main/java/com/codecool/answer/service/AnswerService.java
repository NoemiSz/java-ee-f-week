package com.codecool.answer.service;

import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class AnswerService {


    public String getAnswer(){
        String chuckFact= "";
        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            HttpURLConnection urlConn =(HttpURLConnection)url.openConnection();
            urlConn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            urlConn.connect();

            InputStream is = urlConn.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String str = "";
            while (null != (str = br.readLine())) {
                System.out.println(str);
                JSONObject jsonObject = new JSONObject(str);
                chuckFact = (String) jsonObject.get("value");
                return chuckFact;
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chuckFact;
    }
}

