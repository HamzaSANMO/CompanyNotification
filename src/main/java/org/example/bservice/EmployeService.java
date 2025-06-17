package org.example.bservice;

import org.example.SimpleDataI;
import org.example.drepository.EmployeSimpleData;

import java.util.List;

public class EmployeService {
    // Inversion de dependance en utilisant le type de l'interface au lieu de la classe concrete comme propriete
    private SimpleDataI repository;

    // Injection de dependance qui prend en parametre un objet de meme type que l'interface
    public EmployeService (SimpleDataI repository){
        this.repository = repository;
    }

    // Retourne la liste des employé
    public List listEmployees() {
        //initialisation d'un objet compatible à l'interface simpleDataI
        EmployeSimpleData employe = new EmployeSimpleData();
        EmployeService employeService = new EmployeService(employe);
        return repository.loadFile();
    }
}
