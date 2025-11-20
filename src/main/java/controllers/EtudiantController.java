package main.java.controllers;

import annotations.Controller;
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
}
