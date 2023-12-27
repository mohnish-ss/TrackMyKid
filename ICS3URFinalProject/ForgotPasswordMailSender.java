package ICS3URFinalProject;

// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPasswordMailSender {
   public static String codeSent = "";

   public ForgotPasswordMailSender() {
   }

   public static void sendMail(String recepient) throws MessagingException {
      ForgotPasswordGUI.setEmailStatus("Sending");
      Properties properties = new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      String myAccountEmail = "childorganizerapplication@gmail.com";
      String password = "jqwp uatf jhhj ndha";
      Session session = Session.getInstance(properties, new ForgotPasswordMailSender$1(myAccountEmail, password));
      Message message = prepareMessage(session, myAccountEmail, recepient);
      Transport.send(message);
      ForgotPasswordGUI.setEmailStatus("Sent");
   }

   private static Message prepareMessage(Session session, String myAccountEmail, String recepient) throws MessagingException {
      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(myAccountEmail));
         message.setRecipient(RecipientType.TO, new InternetAddress(recepient));
         message.setSubject("Password Reset");
         codeSent = ForgotPasswordGUI.generateRandomCode();
         message.setText("Enter this code on the application to reset your password: " + codeSent);
         return message;
      } catch (AddressException var4) {
         ForgotPasswordGUI.setEmailStatus("Error");
         return null;
      }
   }

   public static String getCodeSent() {
      return codeSent;
   }

   public static void resetCode() {
      codeSent = "";
   }
}
