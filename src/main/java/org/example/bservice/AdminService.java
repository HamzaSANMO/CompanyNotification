package org.example.bservice;

import org.example.SimpleDataI;
import org.example.centity.EmployeObserver;
import org.example.drepository.EmployeSimpleData;

import java.io.IOException;
import java.util.List;

public class AdminService {

    //methode pour la creation d'un nouveau employe
    public void createEmploye(String nom, String prenom, String email) {
        // cree un objet employé
        EmployeObserver employe = new EmployeObserver(nom, prenom, email);

        //instanciation de l'objet pour lire et ecrire des employés dans le json
        EmployeSimpleData dataEmploye = new EmployeSimpleData();
        // Recuperation du contenu du fichier json
        List<EmployeObserver> data = dataEmploye.loadFile();

        //ajout du nouvel employe dans la liste existante
        data.add(employe);
        //mise à jour de la nouvelle liste d'employé
        try {
            dataEmploye.saveFile(data);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

}
