import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Employe{

    public Admin(String idUser, String nom, String prenom, String email, String motDePasse, boolean status, boolean roleAdmin) {
        super(idUser, nom, prenom, email, motDePasse, status, roleAdmin);
        this.setMotDePasse(motDePasse);
    }
   static Admin admin;

    //creation d'une fontion pour enregistrer l'admin dans le json apres l'instanciation
   public static void createAdmin () throws IOException {
        Admin admin = new Admin("", "Sanmo", "Hamza", "hamzasanmo@gmail.com", "Admin123", true, true);
       Gson gson = new Gson();
       String json = gson.toJson(admin); // Convertit l'objet en JSON

       // Écriture dans un fichier
       try (FileWriter writer = new FileWriter("admin.json")) {
           gson.toJson(admin, writer);
       }

       System.out.println("JSON généré : " + json);
   }


   //fonction pour la lecture d'un objet depuis le fichier json
   public static void LireFichier() throws FileNotFoundException {
        Gson gson = new Gson();

        //Lecture depuis un fichier
       try (FileReader reader = new FileReader("employes.json")){
           admin = gson.fromJson(reader, Admin.class);

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

    //fonctionnalité pour permettre à l'admin de creér un compte employer
   public static void AddUser() {
       Scanner scan = new Scanner(System.in);
       Gson gson = new Gson();
       List<Employe> employes = new ArrayList<>();


       File file = new File("employes.json");
       if (file.exists()) {
           try (Reader reader = new FileReader(file)) {
               Type listType = new TypeToken<List<Employe>>(){}.getType();
               employes = gson.fromJson(reader, listType);
           } catch (Exception e) {
               System.out.println("Erreur de lecture : " + e.getMessage());
           }
       }

       // Saisie des infos
       System.out.print("Nom : ");
       String nom = scan.nextLine();

       System.out.print("Prénom : ");
       String prenom = scan.nextLine();

       System.out.print("Email : ");
       String email = scan.nextLine();

       // Vérifier si l'email existe déjà
       boolean existe = employes.stream().anyMatch(e -> e.getEmail().equalsIgnoreCase(email));
       if (existe) {
           System.out.println("Erreur : cet email est déjà utilisé.");
           return;
       }

       // Création et ajout
       Employe nouvelEmploye = new Employe("", nom, prenom, email, "", false, false);
       employes.add(nouvelEmploye);

       List<Employe> newList = // read data
       employes.addAll(newList);


       // Sauvegarde de la liste mise à jour
       try (Writer writer = new FileWriter("employes.json")) {
           gson.toJson(employes, writer);
           System.out.println("Employé ajouté avec succès !");
       } catch (Exception e) {
           System.out.println("Erreur d'écriture : " + e.getMessage());
       }
   }

    public static void main(String[] args) throws IOException {
        createAdmin();
    }

   }




