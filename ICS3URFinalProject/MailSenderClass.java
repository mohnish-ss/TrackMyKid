package ICS3URFinalProject;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSenderClass {
    public MailSenderClass() {
    }

    public static void sendMail(String recepient) throws MessagingException {
        SendEmailScreenGUI.setEmailStatus("Sending");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "childorganizerapplication@gmail.com";
        String password = "jqwp uatf jhhj ndha";
        Session session = Session.getInstance(properties, new MailSenderClass$1(myAccountEmail, password));
        Message message = prepareMessage(session, myAccountEmail, recepient);
        Transport.send(message);
        SendEmailScreenGUI.setEmailStatus("Sent");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient)
            throws MessagingException {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Child Absent");
            message.setText(SendEmailScreenGUI.getEmailText());
            return message;
        } catch (AddressException var4) {
            SendEmailScreenGUI.setEmailStatus("Error, try again");
            return null;
        }
    }
}
