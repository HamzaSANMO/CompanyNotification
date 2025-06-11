package org.example.centity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin extends Employe{

    public Admin(String nom, String prenom, String email) {
        super(nom, prenom, email);
        super.setMotDePasse("Admin123");
        super.setStatus(true);
        super.setRoleAdmin(true);


    }
}




