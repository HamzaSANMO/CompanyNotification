package org.example.drepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.example.centity.Employe;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeRepository {
    //constante qui stock le nom de nom de notre fichier json
    private final String filename = "employeData.json";
    //creation d'un objet gson avec un formatage bien lisible pour sauvegarder er charger nos donnees gson
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //ecrire une liste d'admin dans le gson
    public void saveEmploye (List<Employe> employes) throws IOException {
        try {
            Writer writer = new FileWriter(filename);
            //transforme la liste des employes en json puis l'ecrit dans le fichier
            gson.toJson(employes, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données " + e.getMessage());
        }

    }

    //methode pour lire une liste d'amdins dans le fichier json
    public List<Employe> loadEmploye () {
        try {
            Reader reader = new FileReader(filename);
            Type type = new TypeToken<List<Employe>>(){}.getType();
            //recupere la liste des employes en objet puis fait la lecture
            List<Employe> employes = gson.fromJson(reader, type);
            if (employes == null) {
                return new ArrayList<>();
            }
            else {
                return employes;
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des données" + e.getMessage());
            return new ArrayList<>();
        } catch (JsonSyntaxException e) {
            System.out.println("Erreur lors du chargement des données" + e.getMessage());
            return new ArrayList<>();
        }

    }
}
