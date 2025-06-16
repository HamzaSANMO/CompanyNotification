package org.example.bservice;

import org.example.SujetI;
import org.example.centity.EmployeObserver;
import org.example.ObserverI;
import org.example.drepository.EmployeSimpleData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificationSujet implements SujetI {
    private List<ObserverI> abonnes = new ArrayList<>();
    private EmployeSimpleData employeSimpleData;

    // Injection de dependance
    public NotificationSujet(EmployeSimpleData employeSimpleData) {
        this.employeSimpleData = employeSimpleData;
    }

    @Override
    //methode pour ajouter un abonné en changeant sont status par true
    public void sAbonner(ObserverI user) {
        abonnes.add(user);
        updateStatus( (EmployeObserver) user,true);

    }

    @Override
    //methode pour ajouter un abonné en changeant sont status par true
    public void seDesabonner(ObserverI user) {
        abonnes.remove(user);
        updateStatus( (EmployeObserver) user,false);

    }

    //Mises a jour de la propriete status d'un enployé
    public void updateStatus(EmployeObserver user, boolean status){
        List<EmployeObserver> users = employeSimpleData.loadFile();

        for (EmployeObserver e : users) {
            if (e.getNom().equals(user.getNom()) && e.getEmail().equals(user.getEmail())) {
                e.setStatus(status);
            }

            try {
                employeSimpleData.saveFile(users);
            }

            catch (IOException c) {
                System.out.println(c);
            }

        }
       /* for (Employe e : users) {
            for (ObserverAbonneI o : abonnes) {
                if (o instanceof Employe employe && employe.getNom().equals(e.getNom()) &&
                        employe.getPrenom().equals(e.getPrenom()) &&
                        employe.getEmail().equals(e.getEmail()))

                    e = employe;

                }
            }
        try {
            employeRepository.saveEmploye(users);
        } catch (IOException e) {
            System.out.println(e);
        }

        }*/
    }

    @Override
    public void notifierAbonner(String message, ObserverI expediteur) {
        for ( ObserverI abonne : abonnes) {
            //Verifier que l'expediteur d'un message ne le recoit pas son propre message
            if (expediteur != abonne) {
                abonne.envoyerMessage(message, expediteur);
            }
        }
    }

    @Override
    public boolean estAbonne(ObserverI utilisateur) {
        return false;
    }
}
