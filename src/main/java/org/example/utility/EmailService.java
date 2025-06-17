package org.example.utility;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailService {
    private static final Properties config = new Properties();

    static {
        try(InputStream input = EmailService.class.getClassLoader().getResourceAsStream("emailconfig.properties")) {
            if(input == null) {
                throw new RuntimeException("Fichier emailconfig.properties introuvables !");
            }
            config.load(input);
        } catch (IOException e){
            throw new RuntimeException("Erreur detesté : " + e.getMessage());
        }
    }

    /**
     * Envoi d'un email à des destinataire
     *
     * @param destinataire Adresse email des destinataires
     * @param sujet Objet de l'email
     * @param contenu Texte du message
     */
    public static void envoyerEmail(String destinataire, String sujet, String contenu) {

        //1-Configuration des propriétés SMPT pour Jarkata Mail
        Properties props = new Properties();
        props.put("mail.smtp.auth", config.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", config.getProperty("mail.smtp.starttls.enable"));
        props.put("mail.smtp.host", config.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", config.getProperty("mail.smtp.port"));

        final String email = config.getProperty("mail.smtp.email");
        final String password = config.getProperty("mail.sender.password");

        //2- Creation d'une session authentifiee
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            //3- Construction du message de type email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinataire)
            );
            message.setSubject(sujet);
            message.setText(contenu);

            //4- Envoi effectif du message
            Transport.send(message);
            System.out.println("Email envoyé à :" + destinataire);

        } catch (MessagingException e) {
            //affichage d'une erreur sans interrompre l'exécution du programme
            System.out.println("Erreur lors de l'envoi de l'email à " + destinataire + " : " + e.getMessage());
        }
    }


}
