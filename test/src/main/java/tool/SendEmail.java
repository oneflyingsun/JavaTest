package tool;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang.StringUtils;

/**
 * @author zhaocong
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @ -
 * @ -
 * @ -                                                    __----~~~~~~~~~~~------___
 * @ -                                   .  .   ~~//====......          __--~ ~~
 * @ -                   -.            \_|//     |||\\  ~~~~~~::::... /~
 * @ -                ___-==_       _-~o~  \/    |||  \\            _/~~-
 * @ -        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 * @ -    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 * @ -  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * @ - /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * @ - |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 * @ -          '         ~-|      /|    |-~\~~       __--~~
 * @ -                      |-~~-_/ |    |   ~\_   _-~                /\
 * @ -      龙妈保佑                 /  \     \__   \/~                \__
 * @ -                       _--~ _/ | .-~~____--~-/                  ~~==.
 * @ -                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 * @ -                                 -_     ~\      ~~---l__i__i__i--~~_/
 * @ -                                 _-~-__   ~)  \--______________--~~
 * @ -                               //.-~~~-~_--~- |-------~~~~~~~~
 * @ -                                      //.-~~~--\
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @date 2019-06-04
 * @description:
 */
public class SendEmail {

  private String subject;
  private String content;
  private List<String> to;
  private String type;
  private String fileName;
  private static SendEmail instance = new SendEmail();

  public static SendEmail getInstance() {
    return instance;
  }

  private static final String DEFAULT_EMAIL = "865844249@qq.com";
  private String email = DEFAULT_EMAIL;
  private String pass = "gemvuqlouytrbejc";

  public static void main(String[] args) {
    SendEmail sendEmail=new SendEmail();
    sendEmail.content="内容test";
    sendEmail.subject="主题测试";
    sendEmail.to= Arrays.asList("zhaocong@qipeng.com","865844249@qq.com");
    sendEmail.type="测试type";
    sendEmail.fileName="testtesttest";
    sendEmail.send();
    System.out.println("test");
  }
  public void send() {

    long start = System.currentTimeMillis();

    Properties props = new Properties();

    if (email.endsWith("@qq.com") || email.endsWith("@vip.qq.com") ||
      email.endsWith("@foxmail.com")) {
      props.put("mail.smtp.host", "smtp.qq.com");
    } else {
      //企业邮箱
      props.put("mail.smtp.host", "smtp.exmail.qq.com");
    }

    props.put("mail.smtp.auth", "true");

    Session sendMailSession = Session.getInstance(props,
      new Authenticator() {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(email, pass);
        }
      }
    );

    try {
      Message newMessage = new MimeMessage(sendMailSession);

      newMessage.setFrom(new InternetAddress(email)); // 发件人

      String[] toArray = new String[to.size()];
      int i = 0;
      for (String des : to) {
        newMessage.addRecipient(Message.RecipientType.TO,
          new InternetAddress(des));
        toArray[i] = des;
        i++;
      }

      if (email.equals(DEFAULT_EMAIL)) {
        newMessage.setSubject("[balot]-" + subject);
      } else {
        newMessage.setSubject(subject);
      }
      if (!StringUtils.isBlank(type)) {
        newMessage.setContent(content, type);
      } else {
        newMessage.setText(content);
      }

      Transport.send(newMessage);
    } catch (Exception e) {
    } finally {
    }
  }

}
