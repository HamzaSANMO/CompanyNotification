package org.example.bservice;

import org.example.ObserverI;
import org.example.SimpleDataI;
import org.example.centity.Admin;
import org.example.centity.EmployeObserver;
import org.example.drepository.AdminSimpleData;
import org.example.drepository.EmployeSimpleData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeService {

    // Retourne la liste des employé
    public List<ObserverI> listUsers() {
       EmployeSimpleData dataEmploye = new EmployeSimpleData();
       AdminSimpleData dataAdmin = new AdminSimpleData();

        List<EmployeObserver> listEmploye = dataEmploye.loadFile();
        List<Admin> listAdmin = dataAdmin.loadFile();

        List<ObserverI> users = new ArrayList<>();
        users.addAll(listEmploye);
        users.addAll(listAdmin);
        return users;
    }

}
