import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Employe {
    private String idUser;
    private String nom;
    private  String prenom;
    private String email;
    private String motDePasse;
    private boolean status;
    private boolean roleAdmin;

    public Employe(String idUser, String nom, String prenom, String email, String motDePasse, boolean status, boolean roleAdmin) {
        this.idUser = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = "Kalanso123";
        this.status = status;
        this.roleAdmin = roleAdmin;
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

    static Employe employe;


    /*//creation d'une fontion pour enregistrer les données employer dans le json
    public static void UserDataWrite () throws IOException {
        Employe empoye = new Employe("", "", "", "", "", false, false);
        Gson gson = new Gson();
        String json = gson.toJson(empoye); // Convertit l'objet en JSON

        // Écriture dans un fichier
        try (FileWriter writer = new FileWriter("employes.json")) {
            gson.toJson(empoye, writer);
        }

        System.out.println("JSON généré : " + json);
    }

    //fonction pour la lecture d'un objet depuis le fichier json
    public static void UserDataRead() throws FileNotFoundException {
        Gson gson = new Gson();

        //Lecture depuis un fichier
        try (FileReader reader = new FileReader("employes.json")){
            employe = gson.fromJson(reader, Employe.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/


    //creation de la fonctionnalité connection pour les employés
    public static void seConnecter(String fileName) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        List<Employe> employes = new ArrayList<>();

        // Lecture du fichier s'il existe déjà
        File file = new File(fileName);
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Type listType = new TypeToken<List<Employe>>(){}.getType();
                employes = gson.fromJson(reader, listType);
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
        boolean existe = (employes.stream().anyMatch(e -> e.getEmail().equalsIgnoreCase(emailSaisi)) &&
                employes.stream().anyMatch(e -> e.getMotDePasse().equalsIgnoreCase(passWord)));
        if (existe) {
            System.out.println("Connection réussi !");
            return;
        }

        else {
            System.out.println("L'email ou le mot de passe est incorrect");
        }
    }

    public static void main(String[] args) throws IOException {
        seConnecter();
    }


}

