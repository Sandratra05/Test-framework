package main.java.controllers;

import annotations.Controller;
import annotations.Url;

@Controller
public class Home {
    @Url("/home")
    public String index() {
        return "Welcome to the Home Page!";
    }
}