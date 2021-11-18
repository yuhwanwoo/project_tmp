package com.lunchpick.lunchpick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
