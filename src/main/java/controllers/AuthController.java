package main.java.controllers;

import java.util.Map;

import mg.ririnina.annotations.Authorized;
import mg.ririnina.annotations.Controller;
import mg.ririnina.annotations.GetMapping;
import mg.ririnina.annotations.Role;
import mg.ririnina.annotations.Session;
import mg.ririnina.view.ModelView;

@Controller
public class AuthController {
    @Authorized
    @GetMapping("/profile")
    public ModelView profile(@Session Map<String, Object> session) {
        // Accessible seulement si authentifié
        ModelView mv = new ModelView();
        mv.setView("profile.jsp");
        return mv;
    }

    @Authorized
    @Role("admin")
    @GetMapping("/admin")
    public ModelView admin(@Session Map<String, Object> session) {
        // Accessible seulement si authentifié ET rôle "chef"
        ModelView mv = new ModelView();
        mv.setView("profile.jsp");
        return mv;
    }
}