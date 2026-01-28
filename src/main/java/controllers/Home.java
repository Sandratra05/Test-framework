package main.java.controllers;

import mg.ririnina.annotations.Controller;
import mg.ririnina.annotations.Url;
import mg.ririnina.view.ModelView;

@Controller
public class Home {
    @Url("/home")
    public String index() {
        return "Welcome to the Home Page!";
    }

    @Url("/about")
    public ModelView about() {
        ModelView mv = new ModelView();
        String data = "My framework is the best";
        mv.setView("about.jsp");
        mv.addAttribute("data", data);
        return mv;
    }
    
    @Url("/test/{id}")
    public String test(int id) {
        return "Test reussi " + id;
    }
}