package main.java.entities;

public class Employe {
    private int id;
    private String nom;
    private String poste;
    private Departement dept;

    public Employe() {
    }

    public Employe(String nom, String poste, Departement dept) {
        setNom(nom);
        setPoste(poste);
        setDept(dept);
    }

    public Employe(int id, String nom, String poste,  Departement dept) {
        setId(id);
        setNom(nom);
        setPoste(poste);
        setDept(dept);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    
}
