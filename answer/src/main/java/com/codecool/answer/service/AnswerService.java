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
        int high = 17;
        int low = 1;
        Random random = new Random();
        int num = random.nextInt(high-low) + low;
        List<String> ends = new ArrayList<>(Arrays.asList("/awesome/us","/cool/us","/everyone/:from",
                "/everything/us","/flying/us","/give/us","/immensity/us", "/life/us",
                "/looking/us","/mornin/us", "/no/us","/particular/question/us","/ratsarse/us",
                "/sake/us","/shit/us","/what/us","/zero/us"));

        String answer= "";
        try {
            URL url = new URL("https://foaas.com"+ends.get(num));
            HttpURLConnection urlConn =(HttpURLConnection)url.openConnection();
            urlConn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("Accept", "application/json");
            urlConn.connect();

            InputStream is = urlConn.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String str = "";
            while (null != (str = br.readLine())) {
                JSONObject jsonObject = new JSONObject(str);
                answer = (String) jsonObject.get("message");
                return answer;
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return answer;
    }
}

