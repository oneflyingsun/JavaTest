package tool.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * @author zhaocong
 * @date 2019-06-27
 * @description:
 */
public class MailUtil {
  private static final String HOST = "smtp.qq.com";
  private static final Integer PORT = 25;
  private static final String USERNAME = "865844249@qq.com";
  private static final String PASSWORD = "gemvuqlouytrbejc";
  private static final String emailForm = "865844249@qq.com";
  private static final String timeout = "25000";
  private static final String personal = "Jayce邮件测试";
  private static final String subject = "主题";
  private static final String html = "html测试";
  private static JavaMailSenderImpl mailSender = createMailSender();

  /**
   * 邮件发送器
   *
   * @return 配置好的工具
   */
  private static JavaMailSenderImpl createMailSender() {
    JavaMailSenderImpl sender = new JavaMailSenderImpl();
    sender.setHost(HOST);
    sender.setPort(PORT);
    sender.setUsername(USERNAME);
    sender.setPassword(PASSWORD);
    sender.setDefaultEncoding("Utf-8");
    Properties p = new Properties();
    p.setProperty("mail.smtp.timeout", timeout);
    p.setProperty("mail.smtp.auth", "false");
    sender.setJavaMailProperties(p);
    return sender;
  }

  /**
   * 发送邮件
   *
   * @param to 接受人
   * @param html 发送内容
   * @throws MessagingException 异常
   * @throws UnsupportedEncodingException 异常
   */
  public static void sendMail(String to, String html) throws MessagingException,UnsupportedEncodingException {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    // 设置utf-8或GBK编码，否则邮件会有乱码
    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
    messageHelper.setFrom(emailForm, personal);
    messageHelper.setTo(to);
    messageHelper.setSubject(subject);
    messageHelper.setText(html, true);
//      messageHelper.addAttachment("", new File(""));//附件
    mailSender.send(mimeMessage);
  }

  public static void main(String[] args) {
    try {
      sendMail("865844249@qq.com","<div><a href=\"www.baidu.com\">baidu</a></div>");
    } catch (MessagingException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

}
