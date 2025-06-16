package org.example;

public interface ObserverI {
    void envoyerMessage(String message, ObserverI expediteur);
}
