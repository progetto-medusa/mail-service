package com.progetto_medusa.mail_service.util;

import com.progetto_medusa.mail_service.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageBuilder {

    public String confirmEmailSubcription(UserDTO userDTO) {
        return "<p>\n" + "  <b>Grazie per aver scelto la nostra applicazione!</b> <br /><br />Per confermare l'iscrizione clicca sul link riportato sotto.\n"+"https://progetto-medusa.netlify.app/confirm?token="+userDTO.getConfirmationToken()+
                  "<br />Grazie per averci scelto<br />\n" + "  <br />\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";

    }

    public String newPassword(UserDTO userDTO){
        return "<p>\n" + "  <b>Richiesta di cambio password accettata.</b> \n <br />Ti diamo il benvenuto/a nella nostra\n"
                + "  piattaforma<br /><br />Per cambiare la password copia e il seguente token e inseriscilo sulla piattafora per accedere.\n" + "  - <u>Token:</u> " + userDTO.getConfirmationToken() + "<br />Se hai ulteriori problemi ad accedere non esitare a contattarci<br />\n" + "  <br />\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }

    public String newPasswordConfirmed(UserDTO userDTO){
        return "<p>\n" + "  <b>Richiesta di cambio password terminata correttamente.</b> <br /><br />Per accedere nuovamente alla nella nostra\n"
                + "  piattaforma utilizza la nuova password che hai scelto!<br /> \n" + "<br />Se hai ulteriori problemi ad accedere non esitare a contattarci<br />\n" + "  <br />\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }


    public String customMessage(UserDTO userDTO) {
        return "Ciao, " + userDTO.getUsername() + ", ti stiamo mandando un messaggio\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }

    public String newCampaignToUser(UserDTO userDTO) {
        return "<p>Ciao! " + userDTO.getUsername() + "!</p>  E' disponibile una nuova campagna per te" /*+ INSERIRE NOME CAMPAGNA;*/ + " </p> Per iscriverti accedi all'applicazione e sottoscrivi la partecipazione \n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";

    }

    public String newCampaignToMaster(UserDTO userDTO) {
        return "<p>Ciao! " + userDTO.getUsername() + "!</p>  La campagna da te creata è ora disponibile!" /*+ INSERIRE NOME CAMPAGNA;*/ + " </p> Per avviare la nuova campagna invita i partecipanti o aspetta che abbastanza utenti si iscivano. \n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";

    }

    public String newSubscriptionToCampaign(UserDTO userDTO) {
        return "<p>Grazie! " + userDTO.getUsername() + "!</p>  per esserti iscritto alla Campagna \n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";

    }


    public String newGameSessionStart(UserDTO userDTO) {
        return "<h1>Missiva di convocazione</h1>"
                + "<p>Ciao " + userDTO.getUsername()
                + ", la tua sessione di gioco sta per iniziare. Preparati a entrare in azione!</p>\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }


    public String newMaintenanceNotice() {
        return "<h1>Manutenzione dell'app in corso</h1>"
                + "<p>Stiamo eseguendo operazioni programmate. Il servizio tornerà disponibile a breve. Grazie per la pazienza.</p>\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team Medusa Project>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" ;
    }

}
