package org.example;

public interface ObserverI {
    void recevoirMessage(String message, ObserverI expediteur);
}
