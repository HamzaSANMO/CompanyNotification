package org.example.acontroller;

import java.util.Scanner;

import static org.example.Main.showAdminMenu;
import static org.example.Main.showEmployeeMenu;


// Methodes
public class AuthController {
    private static Scanner scanner = new Scanner(System.in);

    // Méthodes placeholders pour la couche service (à implémenter ailleurs)
    public static boolean login(String username, String password) {
        // Placeholder : appeler la méthode de service pour authentifier l'admin
        return false;
    }

    public static void logout() {
        // Placeholder : appeler la méthode de service pour déconnexion
    }
    // Authentification Admin
    public static void authenticateAdmin() {
        System.out.print("Entrer votre email : ");
        String userMail = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        if (login(userMail, password)) {
            showAdminMenu();
        } else {
            System.out.println("Échec de l'authentification. Retour au menu principal.");
        }
    }

    // Authentification Employé
    public static void authenticateEmployee() {
        System.out.print("Nom d'utilisateur : ");
        String userMail = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        if (login(userMail, password)) {
            showEmployeeMenu(userMail);
        } else {
            System.out.println("Échec de l'authentification. Retour au menu principal.");
        }
    }
}
