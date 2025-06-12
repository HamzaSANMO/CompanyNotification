package org.example.bservice;

import org.example.centity.Employe;
import org.example.centity.ObserverAbonneI;
import org.example.drepository.EmployeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificationService implements SujetNotificationI{
    private List<ObserverAbonneI> abonnes = new ArrayList<>();
    private EmployeRepository employeRepository;

    // Injection de dependance
    public NotificationService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    //methode pour ajouter un abonné en changeant sont status par true
    public void sAbonner(ObserverAbonneI user) {
        abonnes.add(user);
        updateStatus( (Employe) user,true);

    }

    @Override
    //methode pour ajouter un abonné en changeant sont status par true
    public void seDesabonner(ObserverAbonneI user) {
        abonnes.remove(user);
        updateStatus( (Employe) user,false);

    }

    //Mises a jour de la propriete status d'un enployé
    public void updateStatus(Employe user, boolean status){
        List<Employe> users = employeRepository.loadEmploye();

        for (Employe e : users) {
            if (e.getNom().equals(user.getNom()) && e.getEmail().equals(user.getEmail())) {
                e.setStatus(status);
            }

            try {
                employeRepository.saveEmploye(users);
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
    public void notifierAbonner(String message, ObserverAbonneI expediteur) {
        for ( ObserverAbonneI abonne : abonnes) {
            //Verifier que l'expediteur d'un message ne le recoit pas son propre message
            if (expediteur != abonne) {
                abonne.envoyerMessage(message, expediteur);
            }
        }
    }

    @Override
    public boolean estAbonne(ObserverAbonneI utilisateur) {
        return false;
    }
}
