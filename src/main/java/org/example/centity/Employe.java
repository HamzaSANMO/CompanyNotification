package org.example.centity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Employe implements ObserverAbonneI {
    private String idUser;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private boolean status; // Si employé est abonné ou non
    private boolean roleAdmin; // par defaut est false chez Employe, True chez Admin
    private List<String> notificationsRecu;

    public Employe(String nom, String prenom, String email) {
        this.idUser = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = "Kalanso123";
        this.status = false;
        this.roleAdmin = false;
        this.notificationsRecu = new ArrayList<>();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(boolean roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public List<String> getNotificationsRecu() {
        return notificationsRecu;
    }

    public void setNotificationsRecu(List<String> notificationsRecu) {
        this.notificationsRecu = notificationsRecu;
    }

    @Override
    public void envoyerMessage(String message, ObserverAbonneI expediteur) {

    }
}

