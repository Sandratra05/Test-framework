package main.java.controllers;

import java.util.Map;

import annotations.Authorized;
import annotations.Controller;
import annotations.GetMapping;
import annotations.Role;
import annotations.Session;
import view.ModelView;

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