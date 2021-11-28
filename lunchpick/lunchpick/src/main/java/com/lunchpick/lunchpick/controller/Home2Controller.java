package com.lunchpick.lunchpick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Controller
public class Home2Controller {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/locLunchPick")
    public String location() {
        return "location_lunch";
    }

    @RequestMapping("/myLunchPick")
    public String my() {
        return "my_lunch";
    }

    @RequestMapping("/ranLunchPick")
    public String random() {
        return "random_lunch";
    }


    // 임시
    @RequestMapping(value = "/get-tmap-test", method = RequestMethod.GET)
    @ResponseBody
    public String getMovies() throws IOException {

        try {
            String text = URLEncoder.encode("한국", "UTF-8");
            String apiURL = "https://apis.openapi.sk.com/tmap/pois?"
                    + "version=" + "1"
                    + "&searchKeyword=" + "%EB%A7%9B%EC%A7%91"
                    + "&areaLLCode=" + "11"
                    + "&areaLMCode=" + "410"
                    + "&searchType=" + "name"
                    + "&appKey="; //+ tmap_id  api키;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            con.setDoOutput(true);


            System.out.println(con.getURL().toString());

            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
