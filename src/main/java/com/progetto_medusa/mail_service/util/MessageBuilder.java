package com.progetto_medusa.mail_service.util;

//import com.progetto_medusa.mail_service.model.MailFromFormDTO;
import com.progetto_medusa.mail_service.model.Request.UserRequestForm;
import com.progetto_medusa.mail_service.model.Request.UserRequestForm;
import com.progetto_medusa.mail_service.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageBuilder {

    public String confirmEmailSubcription(UserRequestForm userRequestForm) {
        return "<p>\n" + "  <b>Grazie per aver scelto la nostra applicazione!</b> <br /><br />Per confermare l'iscrizione clicca sul link riportato sotto.\n"
                /*+ inserire link conferma*/ + "<br />Grazie per averci scelto<br />\n" + "  <br />\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team di StoCazzo/i>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";

    }
    public String newSubscription(UserDTO userDTO) {
        return "<p>\n" + "  <b>Congratulazioni!</b> <br /><br />Ti diamo il benvenuto/a nella nostra\n"
                + "  piattaforma<br /><br />Per accedere alla piattaforma utilizza le seguenti\n" + "  credenziali:<br />\n" + "  <br />\n" + "  - <u>Email:</u> "
                + userDTO.getMail() + "<br />\n" + "  - <u>Password:</u> " + userDTO.getPassword() + "<br />Grazie per averci scelto<br />\n" + "  <br />\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team di StoCazzo/i>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }


    public String newPassword(UserRequestForm userRequestForm){
        return "<p>\n" + "  <b>Richiesta di cambio password accettata.</b> <br /><br />Ti diamo il benvenuto/a nella nostra\n"
                + "  piattaforma<br /><br />Per accedere momentaneamente alla piattaforma utilizza le seguenti\n" + "  credenziali:<br />\n" + "  <br />\n" + "  - <u>Email:</u> "
                + userRequestForm.getMail() + "<br />\n" + "  - <u>Password:</u> " + userRequestForm.getPassword() + "<br />Se hai ulteriori problemi ad accedere non esitare a contattarci<br />\n" + "  <br />\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team di StoCazzo/i>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }

//da finire
/*public String newCampaign (UserDTO userDTO) {
        return "<p>\n" + "  <b>Congratulazioni!</b> <br /><br />Ti sei iscritto alla campagna \n" /*+ GETNAME eID +
                + "<br />Per accedere alla piattaforma utilizza le seguenti\n" + "  credenziali:<br />\n" + "  <br />\n" + "  - <u>Email:</u> "
                + userDTO.getMail() + "<br />\n" + "  - <u>Password:</u> " + userDTO.getPassword() + "<br />Grazie per averci scelto<br />\n" + "  <br />\n"
                + "  Cordiali saluti,<br />\n" + "  <i>il Team di StoCazzo/i>\n" + "</p>\n" + "<img\n" + "  style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }*/


    public String customMessage(UserDTO userDTO) {
        return "Ciao, " + userDTO.getUsername() + ", ti stiamo mandando un messaggio";
    }


    public String newSubscriptionToCampaign(UserDTO userDTO) {
        return "<p>Grazie per esserti iscritto, " + userDTO.getUsername() + "!</p>";
    }


    public String buildGameSessionStart(UserDTO userDTO) {
        return "<h1>Missiva di convocazione</h1>"
                + "<p>Ciao " + userDTO.getUsername()
                + ", la tua sessione di gioco sta per iniziare. Preparati a entrare in azione!</p>";
    }


    public String buildMaintenanceNotice() {
        return "<h1>Manutenzione dell'app in corso</h1>"
                + "<p>Stiamo eseguendo operazioni programmate. Il servizio tornerà disponibile a breve. Grazie per la pazienza.</p>";
    }
}
