package ICS3URFinalProject;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class ForgotPasswordMailSender$1 extends Authenticator {
   private String val$myAccountEmail;
   private String val$password;

   ForgotPasswordMailSender$1(String var1, String var2) {
      this.val$myAccountEmail = var1;
      this.val$password = var2;
   }

   protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(this.val$myAccountEmail, this.val$password);
   }
}
