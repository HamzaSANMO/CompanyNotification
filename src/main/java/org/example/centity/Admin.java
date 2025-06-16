package org.example.centity;

public class Admin extends EmployeObserver {

    public Admin(String nom, String prenom, String email) {
        super(nom, prenom, email);
        super.setMotDePasse("Admin123");
        super.setStatus(true);
        super.setRoleAdmin(true);


    }
}




