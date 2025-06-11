package org.example.centity;

public interface ObserverAbonneI {
    void envoyerMessage(String message, ObserverAbonneI expediteur);
}
