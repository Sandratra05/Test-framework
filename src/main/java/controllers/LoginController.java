package main.java.controllers;

import mg.ririnina.annotations.Controller;
import mg.ririnina.annotations.GetMapping;
import mg.ririnina.annotations.PostMapping;
import mg.ririnina.annotations.Session;
import jakarta.servlet.http.HttpSession;
import mg.ririnina.view.ModelView;
import java.util.Map;

@Controller
public class LoginController {

    // Afficher le formulaire de login (GET /login)
    @GetMapping("/")
    public ModelView showLogin() {
        ModelView mv = new ModelView();
        mv.setView("login.jsp");  // JSP pour le formulaire
        return mv;
    }

    // Traiter le login (POST /login)
    @PostMapping("/login")
    public ModelView processLogin(String username, String password, @Session Map<String, Object> session) {
        // Simulation de validation (remplace par ta logique réelle)
        if ("admin".equals(username) && "123".equals(password)) {
            // Stocker l'utilisateur en session
            session.put("user", username);
            session.put("role", "dev");
            //session.put("role", "admin");
            //return "Login successful! Redirecting to dashboard... <a href='${pageContext.request.contextPath}/dashboard'>Go to Dashboard</a>";
            ModelView mv = new ModelView();
            mv.setView("home.jsp");
            //mv.addAttribute("user", user);
            //mv.addAttribute("role", role);
            return mv;
        } else {
            return null;
        }
    }

    // Page protégée (GET /dashboard) - vérifie la session
    @GetMapping("/dashboard")
    public ModelView dashboard(@Session Map<String, Object> session) {
        String user = (String) session.get("user");
        if (user == null) {
            //return "Access denied. Please <a href='/login'>login</a> first.";
            ModelView mv = new ModelView();
            mv.setView("accessDenied.jsp");
            return mv;
        }
        String role = (String) session.get("role");
        ModelView mv = new ModelView();
        mv.setView("home.jsp");
        mv.addAttribute("user", user);
        mv.addAttribute("role", role);
        return mv;
    }

    // Logout (GET /logout)
    @GetMapping("/logout")
    public String logout(@Session Map<String, Object> session) {
        session.clear();  // Vide la session
        return "Logged out. <a href='/login'>Login again</a>";
    }
}