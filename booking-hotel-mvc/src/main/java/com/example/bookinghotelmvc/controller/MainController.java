package com.example.bookinghotelmvc.controller;

import com.example.bookinghotelcore.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(ModelMap modelMap) {
        return "index";
    }

}
