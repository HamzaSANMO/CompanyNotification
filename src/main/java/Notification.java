import java.util.Date;
import java.util.List;

public class Notification {
    private String id;
    private String contenu;
    private  String idExpediteur;
    private List<String> idDestinataires;
    private Date dateEnvoi;

    public Notification(String id, String contenu, String idExpediteur, List<String> idDestinataires, Date dateEnvoi) {
        this.id = id;
        this.contenu = contenu;
        this.idExpediteur = idExpediteur;
        this.idDestinataires = idDestinataires;
        this.dateEnvoi = dateEnvoi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getIdExpediteur() {
        return idExpediteur;
    }

    public void setIdExpediteur(String idExpediteur) {
        this.idExpediteur = idExpediteur;
    }

    public List<String> getIdDestinataires() {
        return idDestinataires;
    }

    public void setIdDestinataires(List<String> idDestinataires) {
        this.idDestinataires = idDestinataires;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
}
