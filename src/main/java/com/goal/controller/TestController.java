package com.goal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(Model model){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping("/toOne")
    public String toOne(){
        return "1";
    }

}
