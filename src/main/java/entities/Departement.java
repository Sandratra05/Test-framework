package main.java.entities;

public class Departement {
    private int id;
    private String nom;

    public Departement() {
    }

    public Departement(String nom) {
        setNom(nom);
    }

    public Departement(int id, String nom) {
        setId(id);
        setNom(nom);
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
}
