package main.java.controllers;

import java.util.Map;

import annotations.Controller;
import annotations.GetMapping;
import annotations.PostMapping;
import annotations.RequestParam;
import annotations.Url;
import view.ModelView;

@Controller
public class EtudiantController {

    @Url("/etudiant")
    public ModelView etudiantForm() { 
        ModelView mv = new ModelView();
        mv.setView("form.jsp");

        return mv;
    }

    @Url("/etudiant/save")
    public String save(String nom, int id) {
        return "Etudiant " + nom + " avec l'id " + id + " est bien enregistre.";
    }

    @Url("/etudiantParam")
    public ModelView etudiantFormParam() { 
        ModelView mv = new ModelView();
        mv.setView("form-param.jsp");

        return mv;
    }

    @Url("/etudiant/saveWithParam")
    public String save(@RequestParam("id") int idEtudiant, @RequestParam("nom") String nomEtudiant) {
        return "Etudiant " + nomEtudiant + " avec l'id " + idEtudiant + " est bien enregistre. (Avec RequestParam)";
    }

    @PostMapping("/etudiant/save")
    public String savePost(@RequestParam("nom") String nomEtudiant, int id) {
        return "Etudiant " + nomEtudiant + " avec l'id " + id + " est bien enregistre via POST.";
    }

    @GetMapping("/etudiant/save")
    public String saveGet(String nom, int id) {
        return "Etudiant " + nom + " avec l'id " + id + " est bien enregistre via GET.";
    }

    @GetMapping("/form-map")
    public ModelView formMap(){ 
        ModelView mv = new ModelView();
        mv.setView("form-map.jsp");

        return mv; 
    }
    
    @PostMapping("/etudiant/saveMap")
    public String savePostEtu(Map<String, Object> params) {
        Integer id = (Integer) params.get("id");
        String nom = (String) params.get("nom");
        return "Etudiant " + nom + " avec l'id " + id + " est bien enregistre avec un argument Map.";
        
    }
}
