package main.java.controllers;

import annotations.Controller;
import annotations.Url;
import view.ModelView;

@Controller
public class Home {
    @Url("/home")
    public String index() {
        return "Welcome to the Home Page!";
    }

    @Url("/about")
    public ModelView about() {
        ModelView mv = new ModelView();
        mv.setView("about.jsp");;
        return mv;
    }
}