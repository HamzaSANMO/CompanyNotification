package org.example.acontroller;

import org.example.ObserverI;
import org.example.bservice.EmployeService;
import org.example.centity.Admin;
import org.example.centity.EmployeObserver;
import org.example.utility.EmailService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.example.Main.showAdminMenu;
import static org.example.Main.showEmployeeMenu;


// Methodes
public class AuthController {
    private static Scanner scanner = new Scanner(System.in);
    private static final EmployeService employe = new EmployeService();

    // Méthodes placeholders pour la couche service (à implémenter ailleurs)
    public static void login() {
        while (true) {
            System.out.print("Entrer votre email : ");
            String emailUser = scanner.nextLine().trim();
            System.out.print("Entrer votre mot de passe : ");
            String passwordUser = scanner.nextLine().trim();

            // Vérifier si un champ est vide
            if (emailUser.isEmpty() || passwordUser.isEmpty()) {
                System.out.println("Veuillez remplir tous les champs !");
                continue;
            }

            // Charger la liste des utilisateurs (employés + admins)
            List<ObserverI> users = employe.listUsers();
            boolean userFound = false;

            // Parcourir les utilisateurs
            for (ObserverI user : users) {
                if (user instanceof EmployeObserver emp) {
                    // Vérifier email et mot de passe
                    if (emp.getEmail().equals(emailUser) && emp.getMotDePasse().equals(passwordUser)) {
                        userFound = true;
                        // Rediriger selon le rôle
                        if (emp.isRoleAdmin()) {
                            showAdminMenu((Admin) emp);
                        } else {
                            showEmployeeMenu(emp);
                        }
                        return; // Sortir après connexion réussie
                    }
                }
            }

            // Si aucun utilisateur n'est trouvé
            if (!userFound) {
                System.out.println("Aucun utilisateur correspondant.");
            }
        }
    }
}

   /* public static void logout() {
        // Placeholder : appeler la méthode de service pour déconnexion
    }
    // Authentification Admin
   /* public static void authenticateAdmin() {
        System.out.print("Entrer votre email : ");
        String userMail = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        if (login(userMail, password)) {
            showAdminMenu();
        } else {
            System.out.println("Échec de l'authentification. Retour au menu principal.");
        }
    }*/

    // Authentification Employé
   /* public static void authenticateEmployee() {
        System.out.print("Nom d'utilisateur : ");
        String userMail = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        if (login(userMail, password)) {
            showEmployeeMenu(userMail);
        } else {
            System.out.println("Échec de l'authentification. Retour au menu principal.");
        }
    }*/

