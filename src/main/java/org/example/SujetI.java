package org.example;

public interface SujetI {
    void sAbonner(ObserverI abonneI);
    void seDesabonner(ObserverI abonneI);
    void notifierAbonner(String message, ObserverI abonneI);
    boolean estAbonne(ObserverI utilisateur);

}