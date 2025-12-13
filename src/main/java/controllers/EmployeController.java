package main.java.controllers;

import java.util.List;

import annotations.Controller;
import annotations.GetMapping;
import annotations.JsonResponse;
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

    @JsonResponse
    @GetMapping("/employeJson")
    public Employe getEmploye() {
        Employe e = new Employe();
        e.setId(1);
        e.setNom(null);
        e.setPoste("Developer");
        e.setDept(new Departement(1, "IT"));

        if (e.getNom() == null || e.getNom().isEmpty()) {
            throw new IllegalArgumentException("Nom requis"); // Lève une exception
        }
        
        return e;
    }

    @JsonResponse
    @GetMapping("/employeJsonList")
    public List<Employe> getEmployes() {
        return List.of(
            new Employe(1, "John Doe", "Developer", new Departement(1, "IT")),
            new Employe(2, "Jane Smith", "Manager", new Departement(2, "HR"))
        );
    }
}
