import java.util.Date;
import java.util.List;

public class emailMessage extends Notification{
    public emailMessage(String id, String contenu, String idExpediteur, List<String> idDestinataires, Date dateEnvoi) {
        super(id, contenu, idExpediteur, idDestinataires, dateEnvoi);
    }
}
