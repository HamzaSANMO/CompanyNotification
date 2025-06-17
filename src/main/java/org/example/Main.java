package org.example;

import java.util.Scanner;

import static org.example.acontroller.AdminControler.*;
import static org.example.acontroller.AuthController.login;
import static org.example.acontroller.AuthController.logout;
import static org.example.acontroller.EmployeController.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void showMainMenu() {
        while (true) {
            System.out.println("\n=== Bienvenue dans notre le Systeme de Gestion des Notifications ===");
            System.out.println("1. Se connecter");
            System.out.println("2. Quitter");
            System.out.print("Choisissez une option : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }



    // Menu Admin
    public static void showAdminMenu() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Créer un compte employé");
            System.out.println("2. Vérifier le statut d'un employé");
            System.out.println("3. Envoyer un message");
            System.out.println("4. Voir la liste des employés");
            System.out.println("5. Voir les notifications");
            System.out.println("6. Voir les notifications");
            System.out.println("7. Se déconnecter");
            System.out.print("Choisissez une option : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Nom d'utilisateur : ");
                    String username = scanner.nextLine();
                    System.out.print("Prenom de l'utilisateur : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    createEmployeeAccount(username, prenom, email);
                    break;
                case "2":
                    System.out.print("Nom d'utilisateur de l'employé : ");
                    String empUserMail = scanner.nextLine();
                    checkEmployeeStatus(empUserMail);
                    break;
                case "3":
                    System.out.print("Message : ");
                    String message = scanner.nextLine();
                    sendMessage("admin", message);
                    break;
                case "4":
                    listEmployees();
                    break;
                case "5":
                    viewAdminNotifications();
                    break;
                case "6":
                    deletetEmployees();
                    return; // Retour au menu principal
                case "7":
                    logout();
                    return; // Retour au menu principal
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // Menu Employé
    public static void showEmployeeMenu(String userMail) {
        while (true) {
            System.out.println("\n=== Menu Employé ===");
            System.out.println("1. Envoyer un message");
            System.out.println("2. S'abonner aux notifications");
            System.out.println("3. Se désabonner des notifications");
            System.out.println("4. Afficher la liste des notifications");
            System.out.println("5. Se déconnecter");
            System.out.print("Choisissez une option : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Message : ");
                    String message = scanner.nextLine();
                    sendMessage(userMail, message);
                    break;
                case "2":
                    subscribe(userMail);
                    break;
                case "3":
                    unsubscribe(userMail);
                    break;
                case "4":
                    viewEmployeeNotifications(userMail);
                    break;
                case "5":
                    logout();
                    return; // Retour au menu principal
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // Point d'entrée
    public static void main(String[] args) {
        showMainMenu();
    }

}