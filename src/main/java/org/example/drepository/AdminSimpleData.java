package org.example.drepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.example.SimpleDataI;
import org.example.centity.Admin;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AdminSimpleData implements SimpleDataI<Admin> {
    //constante qui stock le nom de nom de notre fichier json
    private final String filename = "adminData.json";
    //creation d'un objet gson avec un formatage bien lisible pour sauvegarder er charger nos donnees gson
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //ecrire une liste d'admin dans le gson
    @Override
    public void saveFile(List<Admin> admins) throws IOException {
        try {
            Writer writer = new FileWriter(filename);
            //transforme la liste des admins en json puis l'ecrit dans le fichier
            gson.toJson(admins, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données " + e.getMessage());
        }

    }

    //methode pour lire une liste d'amdins dans le fichier json
    @Override
    public List<Admin> loadFile() {
        try {
            Reader reader = new FileReader(filename);
            Type type = new TypeToken<List<Admin>>(){}.getType();
            //recupere la liste des admins en objet puis fait la lecture
            List<Admin> admins = gson.fromJson(reader, type);
            if (admins == null) {
                return new ArrayList<>();
            }
            else {
                return admins;
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
