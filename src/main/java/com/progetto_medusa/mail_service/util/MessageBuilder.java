package com.progetto_medusa.mail_service.util;

//import com.progetto_medusa.mail_service.model.MailFromFormDTO;
import com.progetto_medusa.mail_service.model.Request.UserRequestForm;
import com.progetto_medusa.mail_service.model.Request.UserRequestForm;
import com.progetto_medusa.mail_service.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageBuilder {

    public String confirmEmailSubcription(UserRequestForm userRequestForm) {
        return "<p>\n" + "  <b>Grazie per aver scelto la nostra applicazione!</b> <br /><br />Per confermare l'iscrizione clicca sul link riportato sotto.\n"+"https://progetto-medusa.netlify.app/confirm?token="+userRequestForm.getConfirmationToken()+
                  "<br />Grazie per averci scelto<br />\n" + "  <br />\n"
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

//da finire
    /*public String newContact(MailFromFormDTO mailFromFormDTO) {
        return "<p>Salve, c'&egrave; una nuova richiesta di contatto dalla piattaforma, di seguito i dettagli:<br />\n" + "  <br />\n" + "  - <u>Nome:</u> "
                + mailFromFormDTO.getName() + "<br />\n" + "  - <u>Email:</u> " + mailFromFormDTO.getMail() + "<br />\n"
                + "  <br />Di seguito il testo del messaggio:<br /><br /><i>\n" + mailFromFormDTO.getMessage()
                + "</i><br /><br /><b>Contattalo al pi&ugrave; presto per approfondire</b></p><img style=\"width: 300px; height: 78px\"\n"
                + "  src=\"logo.png\"\n" + "  alt=\"Immagine\"\n" + "/>";
    }*/

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
}
