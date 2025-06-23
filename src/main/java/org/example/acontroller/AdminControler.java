package org.example.acontroller;

import org.example.ObserverI;
import org.example.bservice.AdminService;
import org.example.bservice.EmployeService;
import org.example.centity.EmployeObserver;

import java.util.List;

public class AdminControler {

    private static final EmployeService employe = new EmployeService();
    private static final AdminService admin = new AdminService();

    public static void createEmployeeAccount(String nom, String prenom, String email) {
        admin.createEmploye(nom, prenom, email);
        System.out.println("Utilisateur creer avec succès !!");
    }

    public static void checkEmployeeStatus(String username) {
        // Placeholder : appeler la méthode de service pour vérifier le statut
    }



    public static void listEmployees() {
        // Placeholder : appeler la méthode de service pour lister les employés
        System.out.println("Liste des employés : ");
        List<ObserverI> listUsers = employe.listUsers();

        for( ObserverI user : listUsers) {
            if( user instanceof EmployeObserver emp){
                String status = emp.isStatus() ? "Abonné" : "Non Abonné";
                String role = emp.isRoleAdmin() ? "Admin" : "Employé ";
                System.out.printf("Nom complet : %s Email : %s - Status : %s - Role : %s%n",emp.fullName(), emp.getEmail(), status, role);
            }
        }
    }

    public static void viewAdminNotifications() {
        // Placeholder : appeler la méthode de service pour afficher les notifications de l'employé
    }

    public static void deletetEmployees() {
        // Placeholder : appeler la méthode de service pour lister les employés
    }
}
