package org.example.bservice;

import org.example.centity.ObserverAbonneI;

public interface SujetNotificationI {
    void sAbonner(ObserverAbonneI abonneI);
    void seDesabonner(ObserverAbonneI abonneI);
    void notifierAbonner(String message, ObserverAbonneI abonneI);
    boolean estAbonne(ObserverAbonneI utilisateur);

}