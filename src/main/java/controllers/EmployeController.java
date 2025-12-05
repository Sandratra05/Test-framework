package main.java.controllers;

import annotations.Controller;
import annotations.GetMapping;
import annotations.PostMapping;
import main.java.entities.Departement;
import main.java.entities.Employe;
import view.ModelView;

@Controller
public class EmployeController {
    @GetMapping("/employe")
    public ModelView formEmp() {
        ModelView mv = new ModelView();
        mv.setView("form-emp.jsp");
        return mv;
    }

    @PostMapping("/employe/save")
    public String saveEmp(Employe emp, Departement dept) {
        return "Employe "+ emp.getId() + " <strong>" + emp.getNom() + "</strong> avec le poste <strong>" + emp.getPoste() + "</strong> est bien enregistre via POST. Ainsi que le departement " + dept.getId() + " du nom de <strong>" + dept.getNom() + "</strong>.";
    }

    @PostMapping("/employe/save")
    public String saveEmpDept(Employe emp) {
        return "Employe "+ emp.getId() + " <strong>" + emp.getNom() + "</strong> avec le poste <strong>" + emp.getPoste() + "</strong> est bien enregistre via POST. Ainsi que le departement " + emp.getDept().getId() + " du nom de <strong>" + emp.getDept().getNom() + "</strong>.";
    }
}
