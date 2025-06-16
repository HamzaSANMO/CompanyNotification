package org.example.acontroller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.centity.EmployeObserver;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeController {

    public static void seConnecter(String fileName) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        List<EmployeObserver> employeObservers = new ArrayList<>();

        // Lecture du fichier s'il existe déjà
        File file = new File(fileName);
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Type listType = new TypeToken<List<EmployeObserver>>(){}.getType();
                employeObservers = gson.fromJson(reader, listType);
            } catch (Exception e) {
                System.out.println("Erreur de lecture : " + e.getMessage());
            }
        }

        // Saisie des infos
        System.out.print("Entrer votre email : ");
        String emailSaisi = scanner.nextLine();

        System.out.print("Entrer votre mot de passe : ");
        String passWord = scanner.nextLine();

        // Vérifier si l'email existe déjà
        boolean existe = (employeObservers.stream().anyMatch(e -> e.getEmail().equalsIgnoreCase(emailSaisi)) &&
                employeObservers.stream().anyMatch(e -> e.getMotDePasse().equalsIgnoreCase(passWord)));
        if (existe) {
            System.out.println("Connection réussi !");
            return;
        }

        else {
            System.out.println("L'email ou le mot de passe est incorrect");
        }
    }
}
