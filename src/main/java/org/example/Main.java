package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void showMainMenu() {
        while (true) {
            System.out.println("\n=== Bienvenue dans notre le Systeme de Gestion des Notifications ===");
            System.out.println("1. Se connecter en tant qu'Admin");
            System.out.println("2. Se connecter en tant qu'Employé");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    authenticateAdmin();
                    break;
                case "2":
                    authenticateEmployee();
                    break;
                case "3":
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // Authentification Admin
    private static void authenticateAdmin() {
        System.out.print("Nom d'utilisateur : ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        if (loginAdmin(username, password)) {
            showAdminMenu();
        } else {
            System.out.println("Échec de l'authentification. Retour au menu principal.");
        }
    }

    // Authentification Employé
    private static void authenticateEmployee() {
        System.out.print("Nom d'utilisateur : ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        if (loginEmployee(username, password)) {
            showEmployeeMenu(username);
        } else {
            System.out.println("Échec de l'authentification. Retour au menu principal.");
        }
    }

    // Menu Admin
    private static void showAdminMenu() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Créer un compte employé");
            System.out.println("2. Vérifier le statut d'un employé");
            System.out.println("3. Envoyer un message");
            System.out.println("4. Voir la liste des employés");
            System.out.println("5. Voir les notifications");
            System.out.println("6. Se déconnecter");
            System.out.print("Choisissez une option : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Nom d'utilisateur : ");
                    String username = scanner.nextLine();
                    System.out.print("Mot de passe : ");
                    String password = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    createEmployeeAccount(username, password, email);
                    break;
                case "2":
                    System.out.print("Nom d'utilisateur de l'employé : ");
                    String empUsername = scanner.nextLine();
                    checkEmployeeStatus(empUsername);
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
                    logout();
                    return; // Retour au menu principal
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // Menu Employé
    private static void showEmployeeMenu(String username) {
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
                    sendMessage(username, message);
                    break;
                case "2":
                    subscribe(username);
                    break;
                case "3":
                    unsubscribe(username);
                    break;
                case "4":
                    viewEmployeeNotifications(username);
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
}